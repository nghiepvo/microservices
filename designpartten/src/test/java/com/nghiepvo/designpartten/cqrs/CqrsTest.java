package com.nghiepvo.designpartten.cqrs;

import com.nghiepvo.designpartten.cqrs.aggregates.UserAggregate;
import com.nghiepvo.designpartten.cqrs.commands.CreateUserCommand;
import com.nghiepvo.designpartten.cqrs.commands.UpdateUserCommand;
import com.nghiepvo.designpartten.cqrs.projections.UserProjection;
import com.nghiepvo.designpartten.cqrs.projectors.UserProjector;
import com.nghiepvo.designpartten.cqrs.queries.AddressByRegionQuery;
import com.nghiepvo.designpartten.cqrs.queries.ContactByTypeQuery;
import com.nghiepvo.designpartten.cqrs.repositories.UserReadRepository;
import com.nghiepvo.designpartten.cqrs.repositories.UserWriteRepository;
import com.nghiepvo.designpartten.domain.Address;
import com.nghiepvo.designpartten.domain.Contact;
import com.nghiepvo.designpartten.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CqrsTest {

    private UserWriteRepository writeRepository;
    private UserReadRepository readRepository;
    private UserProjector projector;
    private UserAggregate userAggregate;
    private UserProjection userProjection;

    @BeforeEach
    public void setUp() {
        writeRepository = new UserWriteRepository();
        readRepository = new UserReadRepository();
        projector = new UserProjector(readRepository);
        userAggregate = new UserAggregate(writeRepository);
        userProjection = new UserProjection(readRepository);
    }

    @Test
    public void givenCQRSApplication_whenCommandRun_thenQueryShouldReturnResult() throws Exception {
        String userId = UUID.randomUUID()
                .toString();
        User user = null;
        CreateUserCommand createUserCommand = new CreateUserCommand(userId, "Tom", "Sawyer");
        user = userAggregate.handleCreateUserCommand(createUserCommand);
        projector.project(user);

        UpdateUserCommand updateUserCommand = new UpdateUserCommand(user.getId(), Stream.of(new Address("New York", "NY", "10001"), new Address("Los Angeles", "CA", "90001"))
                .collect(Collectors.toSet()),
                Stream.of(new Contact("EMAIL", "tom.sawyer@gmail.com"), new Contact("EMAIL", "tom.sawyer@rediff.com"))
                        .collect(Collectors.toSet()));
        user = userAggregate.handleUpdateUserCommand(updateUserCommand);
        projector.project(user);

        updateUserCommand = new UpdateUserCommand(userId, Stream.of(new Address("New York", "NY", "10001"), new Address("Housten", "TX", "77001"))
                .collect(Collectors.toSet()),
                Stream.of(new Contact("EMAIL", "tom.sawyer@gmail.com"), new Contact("PHONE", "700-000-0001"))
                        .collect(Collectors.toSet()));
        user = userAggregate.handleUpdateUserCommand(updateUserCommand);
        projector.project(user);

        ContactByTypeQuery contactByTypeQuery = new ContactByTypeQuery(userId, "EMAIL");
        assertEquals(Stream.of(new Contact("EMAIL", "tom.sawyer@gmail.com"))
                .collect(Collectors.toSet()), userProjection.handle(contactByTypeQuery));
        AddressByRegionQuery addressByRegionQuery = new AddressByRegionQuery(userId, "NY");
        assertEquals(Stream.of(new Address("New York", "NY", "10001"))
                .collect(Collectors.toSet()), userProjection.handle(addressByRegionQuery));

    }
}
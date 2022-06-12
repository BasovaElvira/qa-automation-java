package com.tcs.edu;

import com.tcs.edu.domain.LogException;
import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Order;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.interfaces.MessageService;
import com.tcs.edu.services.DecoratorMessageService;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * TestCase
 */
@Nested
public class SearchingMessagesTests {
    /**
     * Test method
     *
     * BDD
     */
    @Nested
    @DisplayName("Homework 12, task 1, searching by primary key")
    class SearchingByPrimaryKey {

        @Test
        @DisplayName("with simple message")
        public void searchByPrimaryKeySimpleMessage() {

            //given
            MessageService service = new DecoratorMessageService();
            final ArrayList<Message> simpleArrayOfMessages = new ArrayList<>();
            simpleArrayOfMessages.add(new Message("Hello1"));
            simpleArrayOfMessages.add(new Message("Hello2"));
            simpleArrayOfMessages.add(new Message("Hello3"));
            simpleArrayOfMessages.add(new Message("Hello4"));

            //when
            final String[] generatedKeys = service.log(
                    new Message("Hello1"),
                    new Message("Hello2"),
                    new Message("Hello3"),
                    new Message("Hello4")
            );

            //then
            for(int i = 0; i < generatedKeys.length; i++) {
            Assertions.assertEquals(service.findByPrimaryKey(generatedKeys[i]), simpleArrayOfMessages.get(i));
            }
        }

        @Test
        @DisplayName("with empty message")
        public void searchByPrimaryKeyMessageWithNull() throws LogException {

            //given
            MessageService service = new DecoratorMessageService();


            //when
            Message nullMessage = new Message(null);

            //then
            try {
                service.log(nullMessage);
            } catch (LogException thrown) {
                Assertions.assertEquals("message can not be null", thrown.getMessage());
            }
        }
    }

    @Nested
    @DisplayName("Homework 12, task 2, Showing all messages")
    class SearchingAll{

        @Test
        @DisplayName("all messages")
        public void findAllMessages() {
            MessageService service = new DecoratorMessageService();
            final ArrayList<Message> simpleArrayOfMessages = new ArrayList<>();
            simpleArrayOfMessages.add(0, new Message("Hello"));
            simpleArrayOfMessages.add(1, new Message("By"));

            //when
            service.log(
                    new Message("Hello"),
                    new Message("By")
            );

            //then
            assertThat(service.findAll().toString()).isEqualTo(simpleArrayOfMessages.toString());
        }
    }

    @Nested
    @DisplayName("Homework 12, task 3, search by severity")
    class SearchingBySeverity {

        @Test
        @DisplayName("only chosen severity")
        public void findBySeverity(){
            //given
            MessageService service = new DecoratorMessageService();

            //when
            service.log(
                    Order.DESK,
                    new Message(Severity.REGULAR,"Hello1"),
                    new Message(Severity.MAJOR,"Hello2"),
                    new Message(Severity.REGULAR,"Hello3"),
                    new Message(Severity.MAJOR,"Hello4")
            );

            //then
            for (Message current : service.findBySeverity(Severity.MAJOR)) {
                assertThat(current.getSeverity()).isEqualTo(Severity.MAJOR);
            }

        }
    }
}

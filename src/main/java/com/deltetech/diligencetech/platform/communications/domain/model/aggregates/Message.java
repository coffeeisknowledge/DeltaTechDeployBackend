package com.deltetech.diligencetech.platform.communications.domain.model.aggregates;


import com.deltetech.diligencetech.platform.communications.domain.model.valueobjects.AnswersList;
import com.deltetech.diligencetech.platform.communications.domain.model.valueobjects.MessageData;
import com.deltetech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message extends AuditableAbstractAggregateRoot<Message> {

    @Embedded
    private AnswersList answers;

    @Embedded
    private MessageData messageData;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Message question;

    public Message() {}
}

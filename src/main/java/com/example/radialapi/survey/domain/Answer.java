package com.example.radialapi.survey.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Entity
@ToString
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question questionId; // question이라고 하니깐 에러뜸 왜지

    @Column(columnDefinition = "TEXT", nullable = false)
    private String answerText;

    @Column(nullable = false)
    private boolean correct;

    @Builder
    public Answer(Question questionId, String answerText, boolean correct) {
        this.questionId = questionId;
        this.answerText = answerText;
        this.correct = correct;
    }

    // 불린은 getter 적용 안되는 듯
    public boolean getCorrect() {
        return correct;
    }
}

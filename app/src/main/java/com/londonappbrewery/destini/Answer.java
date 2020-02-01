package com.londonappbrewery.destini;

public class Answer {
    private int answer_id;
    private int next_phase;

    public Answer(int answer_id, int next_phase){
        this.answer_id = answer_id;
        this.next_phase = next_phase;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getNext_phase() {
        return next_phase;
    }

    public void setNext_phase(int next_phase) {
        this.next_phase = next_phase;
    }
}

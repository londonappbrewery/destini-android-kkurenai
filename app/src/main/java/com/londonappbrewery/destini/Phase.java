package com.londonappbrewery.destini;

public class Phase {

    int phaseNumber;
    int story_part_id;
    Answer[] answers;
    public Phase(int phaseNumber, Answer[] answers, int story_part_id){
        this.phaseNumber = phaseNumber;
        this.answers = answers;
        this.story_part_id = story_part_id;
    }

    public int getPhaseNumber() {
        return phaseNumber;
    }

    public void setPhaseNumber(int phaseNumber) {
        this.phaseNumber = phaseNumber;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }

    public int getStory_part_id() {
        return story_part_id;
    }

    public void setStory_part_id(int story_part_id) {
        this.story_part_id = story_part_id;
    }
}

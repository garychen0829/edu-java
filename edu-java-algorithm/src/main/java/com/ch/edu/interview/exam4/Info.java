package com.ch.edu.interview.exam4;

public class Info{
    int msgId;
    int score; //质量分
    int type; //0为系统消息，1为推荐消息

    @Override
    public String toString() {
        return "Info{" +
                "msgId=" + msgId +
                ", score=" + score +
                ", type=" + type +
                '}';
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
package com.example.studyroom.Models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

public class Group implements Parcelable {
    private String id;
    private String className;
    private int currNumber;
    private int totalNumber;
    private String teamName;
    private String img;
    private boolean examSquad;
    private boolean homeworkHelp;
    private boolean labMates;
    private boolean noteExchange;
    private boolean projectPartners;
    private Map<String, Boolean> leaders;
    private Map<String, Boolean> members;
    private String groupDescription;

    public Group() {
        // Default constructor required for Firestore deserialization
    }

    public Group(String id, String className, int currNumber, int totalNumber, String teamName,
                 String img, boolean examSquad, boolean homeworkHelp, boolean labMates,
                 boolean noteExchange, boolean projectPartners, Map<String, Boolean> leaders,
                 Map<String, Boolean> members, String groupDescription) {
        this.id = id;
        this.className = className;
        this.currNumber = currNumber;
        this.totalNumber = totalNumber;
        this.teamName = teamName;
        this.img = img;
        this.examSquad = examSquad;
        this.homeworkHelp = homeworkHelp;
        this.labMates = labMates;
        this.noteExchange = noteExchange;
        this.projectPartners = projectPartners;
        this.leaders = leaders;
        this.members = members;
        this.groupDescription = groupDescription;
    }

    protected Group(Parcel in) {
        id = in.readString();
        className = in.readString();
        currNumber = in.readInt();
        totalNumber = in.readInt();
        teamName = in.readString();
        img = in.readString();
        examSquad = in.readByte() != 0;
        homeworkHelp = in.readByte() != 0;
        labMates = in.readByte() != 0;
        noteExchange = in.readByte() != 0;
        projectPartners = in.readByte() != 0;
        groupDescription = in.readString();
    }

    public static final Creator<Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel in) {
            return new Group(in);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public int getCurrNumber() {
        return currNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getImg() {
        return img;
    }

    public boolean isExamSquad() {
        return examSquad;
    }

    public boolean isHomeworkHelp() {
        return homeworkHelp;
    }

    public boolean isLabMates() {
        return labMates;
    }

    public boolean isNoteExchange() {
        return noteExchange;
    }

    public boolean isProjectPartners() {
        return projectPartners;
    }

    public Map<String, Boolean> getLeaders() {
        return leaders;
    }

    public Map<String, Boolean> getMembers() {
        return members;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(className);
        dest.writeInt(currNumber);
        dest.writeInt(totalNumber);
        dest.writeString(teamName);
        dest.writeString(img);
        dest.writeByte((byte) (examSquad ? 1 : 0));
        dest.writeByte((byte) (homeworkHelp ? 1 : 0));
        dest.writeByte((byte) (labMates ? 1 : 0));
        dest.writeByte((byte) (noteExchange ? 1 : 0));
        dest.writeByte((byte) (projectPartners ? 1 : 0));
        dest.writeString(groupDescription);
    }
}

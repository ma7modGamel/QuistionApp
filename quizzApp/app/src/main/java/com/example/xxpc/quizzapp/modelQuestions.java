package com.example.xxpc.quizzapp;


import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class modelQuestions implements Parcelable {
    int photoQuez;
    String answers;
    char typeQ;


    protected modelQuestions(Parcel in) {
        photoQuez = in.readInt();
        answers = in.readString();
        typeQ = (char) in.readInt();
    }

    public static final Creator<modelQuestions> CREATOR = new Creator<modelQuestions>() {
        @Override
        public modelQuestions createFromParcel(Parcel in) {
            return new modelQuestions(in);
        }

        @Override
        public modelQuestions[] newArray(int size) {
            return new modelQuestions[size];
        }
    };

    public int getPhotoQuez() {
        return photoQuez;
    }

    public void setPhotoQuez(int photoQuez) {
        this.photoQuez = photoQuez;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public char getTypeQ() {
        return typeQ;
    }

    public void setTypeQ(char typeQ) {
        this.typeQ = typeQ;
    }

    public modelQuestions(int photoQuez, String answers, char typeQ) {
        this.photoQuez = photoQuez;
        this.answers = answers;
        this.typeQ = typeQ;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(photoQuez);
        parcel.writeString(answers);
        parcel.writeInt((int) typeQ);
    }
}


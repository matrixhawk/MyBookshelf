//Copyright (c) 2017. 章钦豪. All rights reserved.
package com.monke.monkeybook.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.monke.monkeybook.help.BookshelfHelp;
import com.monke.monkeybook.model.source.My716;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

@Entity
public class SearchBookBean implements Parcelable{
    @Id
    private String noteUrl;
    private String coverUrl;//封面URL
    private String name;
    private String author;
    private String tag;
    private String kind;//分类
    private String origin;//来源
    private String desc;
    private String lastChapter;
    private String introduce; //简介
    private String chapterUrl;//目录URL
    private Long addTime = 0L;
    private Long upTime = 0L;
    @Transient
    private long words;
    @Transient
    private String state;
    @Transient
    private Boolean isAdd = false;
    @Transient
    private int originNum = 1;
    @Transient
    private int weight = -1;
    @Transient
    private int lastChapterNum = -2;
    @Transient
    private int searchTime = Integer.MAX_VALUE;

    public SearchBookBean(){

    }

    protected SearchBookBean(Parcel in) {
        noteUrl = in.readString();
        coverUrl = in.readString();
        name = in.readString();
        author = in.readString();
        words = in.readLong();
        state = in.readString();
        lastChapter = in.readString();
        isAdd = in.readByte() != 0;
        tag = in.readString();
        kind = in.readString();
        origin = in.readString();
        desc = in.readString();
        originNum = in.readInt();
        introduce = in.readString();
        chapterUrl = in.readString();
        addTime = in.readLong();
        upTime = in.readLong();
    }

    @Generated(hash = 1330499490)
    public SearchBookBean(String noteUrl, String coverUrl, String name, String author,
            String tag, String kind, String origin, String desc, String lastChapter,
            String introduce, String chapterUrl, Long addTime, Long upTime) {
        this.noteUrl = noteUrl;
        this.coverUrl = coverUrl;
        this.name = name;
        this.author = author;
        this.tag = tag;
        this.kind = kind;
        this.origin = origin;
        this.desc = desc;
        this.lastChapter = lastChapter;
        this.introduce = introduce;
        this.chapterUrl = chapterUrl;
        this.addTime = addTime;
        this.upTime = upTime;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteUrl);
        dest.writeString(coverUrl);
        dest.writeString(name);
        dest.writeString(author);
        dest.writeLong(words);
        dest.writeString(state);
        dest.writeString(lastChapter);
        dest.writeByte((byte)(isAdd?1:0));
        dest.writeString(tag);
        dest.writeString(kind);
        dest.writeString(origin);
        dest.writeString(desc);
        dest.writeInt(originNum);
        dest.writeString(introduce);
        dest.writeString(chapterUrl);
        dest.writeLong(addTime);
        dest.writeLong(upTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SearchBookBean> CREATOR = new Creator<SearchBookBean>() {
        @Override
        public SearchBookBean createFromParcel(Parcel in) {
            return new SearchBookBean(in);
        }

        @Override
        public SearchBookBean[] newArray(int size) {
            return new SearchBookBean[size];
        }
    };

    public String getNoteUrl() {
        return noteUrl;
    }

    public void setNoteUrl(String noteUrl) {
        this.noteUrl = noteUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null ? name.trim().replaceAll("　", "") : null;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author != null ? author.trim().replaceAll("[（【】）　]", "") : null;
    }

    public long getWords() {
        return words;
    }

    public void setWords(long words) {
        this.words = words;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLastChapter() {
        return lastChapter==null?"":lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;

    }

    public int getLastChapterNum() {
        if (lastChapterNum == -2)
            this.lastChapterNum = BookshelfHelp.guessChapterNum(lastChapter);
        return lastChapterNum;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getIsAdd() {
        return this.isAdd;
    }

    public void setIsAdd(Boolean isAdd) {
        this.isAdd = isAdd;
        if (isAdd)
            this.addTime = System.currentTimeMillis();
    }

    public void originNumAdd() {
        originNum = originNum + 1;
    }

    public int getOriginNum() {
        return originNum;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getChapterUrl() {
        return this.chapterUrl;
    }

    public void setChapterUrl(String chapterUrl) {
        this.chapterUrl = chapterUrl;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public int getWeight() {
        if (weight < 0) {
            if (tag.equals(My716.TAG))
                this.weight = Integer.MAX_VALUE;
            else {
                BookSourceBean source = BookshelfHelp.getBookSourceByTag(this.tag);
                if (source != null)
                    this.weight = source.getWeight();
                else
                    this.weight = 0;
            }
        }
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(int searchTime) {
        this.searchTime = searchTime;
    }

    public Long getUpTime() {
        return this.upTime;
    }

    public void setUpTime(Long upTime) {
        this.upTime = upTime;
    }
}

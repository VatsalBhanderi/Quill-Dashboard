package com.example.quill.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marketing {
//campaign_id,campaign_name,channel_id,channel_name,campaign_date,performance_score

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int campaignId;
	private String campaignName;
	private String channelName;
	private int channelId;
	private String campaignDate;
	private int score;
	
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getCampaignDate() {
		return campaignDate;
	}
	public void setCampaignDate(String campaignDate) {
		this.campaignDate = campaignDate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}

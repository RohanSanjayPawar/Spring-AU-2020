package com.accolite.model;

import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
@NamedNativeQuery(name = "Player.getPlayer", query = "SELECT * FROM Player", resultClass=Player.class)
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String Name;
	private int goals;

	@OneToMany
	@JoinTable(name = "PLAYER_CLUBS", joinColumns = @JoinColumn(name = "PLAYER_ID"), inverseJoinColumns = @JoinColumn(name = "CLUB_ID"))
	private Collection<ClubTeam> clubs;

	@Override
	public String toString() {
		return "Player [id=" + id + ", Name=" + Name + ", goals=" + goals + ", clubs=" + clubs + ", nationalTeam="
				+ nationalTeam + "]";
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "clubName", column = @Column(name = "CLUB_NAME")),
			@AttributeOverride(name = "present", column = @Column(name = "PRESENT_IN_CLUB")) })
	private NationalTeam nationalTeam;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals() {
		int goals = 0;
		for (Team clubTeam : clubs) {
			System.out.println("GOALS: " + clubTeam.getGoals());
			goals += clubTeam.getGoals();
		}
		goals += this.getNationalTeam().getGoals();
		this.goals = goals;
	}

	public Collection<ClubTeam> getClubs() {
		return clubs;
	}

	public void setClubs(Collection<ClubTeam> clubs) {
		this.clubs = clubs;
	}

	public NationalTeam getNationalTeam() {
		return nationalTeam;
	}

	public void setNationalTeam(NationalTeam nationalTeam) {
		this.nationalTeam = nationalTeam;
	}
}

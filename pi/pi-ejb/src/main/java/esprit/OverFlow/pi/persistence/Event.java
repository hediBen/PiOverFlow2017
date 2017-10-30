package persistence;

import java.io.Serializable;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
@XmlRootElement
public class Event implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	private String location;
	private String description;
	private String image;
	@Column(name="vipNb")
	private int vipNb=0;
	@Column(name="chairsNb")
	private int chairsNb=0;
	@Column(name="benchNb")
	private int benchNb=0;
	@Column(name="vipFees", nullable=true)
	private int vipFees;
	@Column(name="chairsFees", nullable=true)
	private int chairsFees;
	@Column(name="benchFees", nullable=true)
	private int benchFees;
	@Temporal(TemporalType.DATE)
    private Date dateEvent;

	private String startsAt;
	
	@ManyToOne
	private User agent;
	
	@OneToMany(mappedBy="event")
	private List<EventBookingDetails> eventBookingDetailsList;
	
	public List<EventBookingDetails> getEventBookingDetails() {
		return eventBookingDetailsList;
	}

	public void setEventBookingDetails(List<EventBookingDetails> eventBookingDetails) {
		this.eventBookingDetailsList = eventBookingDetails;
	}
	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}   
	
	public User getAgent() {
		return (Agent) agent;
	}

	public void setAgent(User agent) {
		this.agent = agent;
	}
	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}   
  
	public int getVipNb() {
		return vipNb;
	}
	public void setVipNb(int vipNb) {
		this.vipNb = vipNb;
	}
	public int getChairsNb() {
		return chairsNb;
	}
	public void setChairsNb(int chairsNb) {
		this.chairsNb = chairsNb;
	}
	public int getBenchNb() {
		return benchNb;
	}
	public void setBenchNb(int benchNb) {
		this.benchNb = benchNb;
	}
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getVipFees() {
		return vipFees;
	}
	public void setVipFees(int vipFees) {
		this.vipFees = vipFees;
	}
	public int getChairsFees() {
		return chairsFees;
	}
	public void setChairsFees(int chairsFees) {
		this.chairsFees = chairsFees;
	}
	public int getBenchFees() {
		return benchFees;
	}
	public void setBenchFees(int benchFees) {
		this.benchFees = benchFees;
	}
	

	public Date getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}
	public String getStartsAt() {
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
		try {
			formatter.parse(startsAt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return startsAt;
	}
	public void setStartsAt(String startsAt) {
		this.startsAt = startsAt;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", category=" + category + ", location=" + location + ", description="
				+ description + ", vipNb=" + vipNb + ", chairsNb=" + chairsNb + ", benchNb=" + benchNb + ", vipFees="
				+ vipFees + ", chairsFees=" + chairsFees + ", benchFees=" + benchFees + ", dateEvent=" + dateEvent
				+ ", startsAt=" + startsAt + ", agent=" + agent + "]";
	}
	public Event( String name, String category,String location, int vipNb,int vipFees,int chairFees,int chairsNb, int benchNb,int benchFees,Date dateEvent ,String startsAt ,String description,User agent,String image) {
		super();
		this.name=name;
		this.location = location;
		this.category = category;
		this.agent=agent;
		this.vipNb=vipNb;
		this.chairsNb=chairsNb;
		this.benchNb=benchNb;
		this.vipFees=vipFees;
		this.chairsFees=chairFees;
		this.benchFees=benchFees;
		this.dateEvent=dateEvent;
		this.startsAt=startsAt;
		this.description=description;
		this.image=image;
	}
	public Event(int id, String location, String category) {
		super();
		this.id=id;
		this.location = location;
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	 
   
}

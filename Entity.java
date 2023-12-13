package gamingroom;
public class Entity {
	protected long id;
	protected String name;
	
	//default constructor to allow child classes to view it
	protected Entity() {}
	
	public Entity() {
		this.id = 0;
		this.name = "";
	}
	
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Entity (id = " + id _ ", name = " + name + ")";
	}

}

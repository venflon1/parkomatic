package parcomatic.model;

import parcomatic.exception.SizeFloorException;

public class Parkomatic {

	private int[] floor = new int[6];
	
	public Parkomatic(int sizeF1, Integer sizeF2, int sizeF3, int sizeF4, int sizeF5, int sizeF6) throws SizeFloorException {
		super();
		
			validateSizeFloor(sizeF1);
			validateSizeFloor(sizeF2);		
			validateSizeFloor(sizeF3);
			validateSizeFloor(sizeF4);	
			validateSizeFloor(sizeF5);		
			validateSizeFloor(sizeF6);
		
		this.floor[0] = sizeF1;
		this.floor[1] = sizeF2;
		this.floor[2] = sizeF3;
		this.floor[3] = sizeF4;
		this.floor[4] = sizeF5;
		this.floor[5] = sizeF6;
	}
	
	public Parkomatic(int sizeF1, int sizeF2, int sizeF3, int sizeF4, int sizeF5) throws SizeFloorException {
		this(sizeF1, sizeF2, sizeF3, sizeF4, sizeF5, 0);
	}
	
	public Parkomatic(int sizeF1, int sizeF2, int sizeF3, int sizeF4) throws SizeFloorException {
		this(sizeF1, sizeF2, sizeF3, sizeF4, 0, 0);
	}
	
	public Parkomatic(int sizeF1, int sizeF2, int sizeF3) throws SizeFloorException {
		this(sizeF1, sizeF2, sizeF3, 0, 0, 0);
	}
	
	public Parkomatic(int sizeF1, int sizeF2) throws SizeFloorException {
		this(sizeF1, sizeF2, 0, 0, 0, 0);
	}
	
	public Parkomatic(int sizeF1) throws SizeFloorException {
		this(sizeF1, 0, 0, 0, 0, 0);
	}
	
	public Parkomatic() throws SizeFloorException {
		this(0, 0, 0, 0, 0, 0);
	}
	
	public int[] getFloor() {
		return floor;
	}

	public void setFloor(int[] floor) {
		this.floor = floor;
	}

	private void validateSizeFloor(int sizeFloor) throws SizeFloorException {
		if(sizeFloor < 0 )
			throw new SizeFloorException("error size floor!");
	}

	public String print(int x) {
		
		String ret="";
		
		if(x>=0 && x<this.floor[0]){
			ret += "A" + (++x);
		}
		else if(x>=this.floor[0] && x<this.floor[0]+this.floor[1]){
			ret += "B" + (x%this.floor[1]);
		}
		else if(x>=this.floor[0]+this.floor[1] && x<this.floor[0]+this.floor[1]+this.floor[2]){
			ret += "C" + ((x%this.floor[2])+1);
		}
		else if(x>=this.floor[0]+this.floor[1]+this.floor[2] && x<this.floor[0]+this.floor[1]+this.floor[2]+this.floor[3]){
			ret += "D" + ((x%this.floor[3])+1);
		}
		else if(x>=this.floor[0]+this.floor[1]+this.floor[2]+this.floor[3] && x<this.floor[0]+this.floor[1]+this.floor[2]+this.floor[3]+this.floor[4]){
			ret += "E" + ((x%this.floor[4])+1);
		}
		else
			ret += "F" + ((x%this.floor[5])+1);
		System.out.println(ret);
		return ret;
	}
	
	public static void main(String[] args) throws SizeFloorException {
        Parkomatic parkomatic = new Parkomatic(100, 50, 50);
        parkomatic.print(0);
        parkomatic.print(199);
        parkomatic.print(50);
        parkomatic.print(34);
        parkomatic.print(114);
        parkomatic.print(150);
        parkomatic.print(190);
	}
}

public class Eagle extends Bird implements Fly{

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude){
        this.altitude = altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    public void setFling(boolean flying){
        this.flying = flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    /**
     * takes off, must be on the ground
     */
    @Override
    public void takeOff(){
        this.flying = true;
        System.out.println(getName()+" takes off in the sky.");
    }

    /**
     * ascends, must be flying
     * @param meters altitude increase
     * @return altitude
     */
    @Override
    public int ascend(int meters){
        if(this.flying){
            this.altitude = Math.min(this.altitude+meters, 6000);
            System.out.println(this.getName()+" flies upward, altitude : "+this.altitude);
        }
        return this.altitude;
    }

    /**
     * descends, must be flying
     * @param meters altitude decrease
     * @return altitude
     */
    @Override
    public int descend(int meters){
        if(this.flying){
            this.altitude = Math.max(this.altitude-meters, 1);
            System.out.println(this.getName()+" flies downward, altitude : "+this.altitude);
        }
        return this.altitude;
    }

    /**
     * descends, must be flying
     * altitude must be at 1, decreases to 0
     * flying stops
     */
    @Override
    public void land(){
        if(this.flying){
            if(this.altitude>1){
                System.out.println(this.getName()+" is too high, it can't land.");
            }
            else{
                this.flying=false;
                this.altitude=0;
                System.out.println(this.getName()+" lands on the ground.");
            }
        }
        else{
            System.out.println(this.getName()+ " is already on the ground.");
        }
    }
}

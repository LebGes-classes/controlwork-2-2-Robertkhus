public class BroadcastsTime implements Comparable<BroadcastsTime> {
    private byte hour;
    private byte minute;
    public BroadcastsTime(byte hour, byte minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public boolean after(BroadcastsTime t) {
        if (this.compareTo(t) < 0) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(BroadcastsTime broadcastsTime) {
        if (this.hour == broadcastsTime.hour) {
            return this.minute - broadcastsTime.minute;
        }
        return this.hour - broadcastsTime.hour;
    }

    public byte getHour() {
        return hour;
    }

    public void setHour(byte hour) {
        this.hour = hour;
    }

    public byte getMinute() {
        return minute;
    }

    public void setMinute(byte minute) {
        this.minute = minute;
    }
}

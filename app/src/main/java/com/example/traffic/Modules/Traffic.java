package com.example.traffic.Modules;

public class Traffic {
    String TrafficSignImage;
    String TrafficSignName;
    String TrafficSignDescription;

    public Traffic(String trafficSignName, String trafficSignDescription,String trafficSignImage) {
        TrafficSignImage = trafficSignImage;
        TrafficSignName = trafficSignName;
        TrafficSignDescription = trafficSignDescription;
    }

    public String getTrafficSignImage() {
        return TrafficSignImage;
    }

    public void setTrafficSignImage(String trafficSignImage) {
        TrafficSignImage = trafficSignImage;
    }

    public String getTrafficSignName() {
        return TrafficSignName;
    }

    public void setTrafficSignName(String trafficSignName) {
        TrafficSignName = trafficSignName;
    }

    public String getTrafficSignDescription() {
        return TrafficSignDescription;
    }

    public void setTrafficSignDescription(String trafficSignDescription) {
        TrafficSignDescription = trafficSignDescription;
    }
}

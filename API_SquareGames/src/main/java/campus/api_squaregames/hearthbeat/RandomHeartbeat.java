package campus.api_squaregames.hearthbeat;

import campus.api_squaregames.hearthbeat.HeartbeatSensor;
import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor {
    
    @Override
    public int get(int i) {
        return (int)Math.round(Math.random()*i);
    }


}

package campus.api_squaregames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class HeartbeatController {

    @Autowired
    private HeartbeatSensor heartbeatSensor;

    @Autowired
    private GameCatalog gameCatalog;

    @PostMapping("/heartbeat")
    public int getHearbeat() {
        return heartbeatSensor.get(100);
    }

    @GetMapping("/heartbeat2")
    public Collection<String> getGameCatalog() {
        return gameCatalog.getGameIdentifiers();
    }
}

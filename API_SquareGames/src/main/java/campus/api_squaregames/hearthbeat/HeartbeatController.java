package campus.api_squaregames.hearthbeat;

import campus.api_squaregames.service.GameCatalog;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

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
    public Map<String, GameFactory> getGameCatalog() {
        return gameCatalog.getGameIdentifiers();
    }
}

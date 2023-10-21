package rpg.solo.oracles.mune.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MUNEController {
    @GetMapping("/YesNoResponse")
    public ResponseEntity<MUNEResponse> yesNoResponse(@RequestParam(value = "odds", defaultValue = "Normal") String oddsStr) {
        MUNEOddsTypes odds = MUNEOddsTypes.getOddsForString(oddsStr);
        if (odds.equals(MUNEOddsTypes.NO_ODDS)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MUNEErrorResponse("Invalid value for parameter 'odds'. Accepted values are NORMAL, UNLIKELY and LIKELY."));
        }
        return ResponseEntity.ok(new MUNEYesNoResponse(odds.getOdds()));
    }
}

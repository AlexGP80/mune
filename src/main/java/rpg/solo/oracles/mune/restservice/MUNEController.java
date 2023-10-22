package rpg.solo.oracles.mune.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rpg.solo.oracles.mune.util.RequestParamsUtils;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("MUNE")
public class MUNEController {
    @GetMapping("/YesNoResponse")
    public ResponseEntity<MUNEResponse> yesNoResponse(@RequestParam Map<String, String> requestParams) {
        String oddsStr = requestParams.remove("odds");
        String spuriousParams = RequestParamsUtils.getSpuriousParamsStr(requestParams, new ArrayList<>());
        if (!spuriousParams.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new MUNEErrorResponse("Unknown spurious params: " + spuriousParams));
        }
        MUNEOddsTypes odds = MUNEOddsTypes.getOddsForString(oddsStr);
        if (odds.equals(MUNEOddsTypes.NO_ODDS)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new MUNEErrorResponse(
                            "Invalid value for parameter 'odds'. Accepted values are NORMAL, UNLIKELY and LIKELY."));
        }
        return ResponseEntity.ok(new MUNEYesNoResponse(odds.getOdds()));
    }
}

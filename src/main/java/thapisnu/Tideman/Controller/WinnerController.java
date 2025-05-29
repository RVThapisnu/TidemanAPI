package thapisnu.Tideman.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

import thapisnu.Tideman.Service.WinnerService;
import thapisnu.Tideman.Model.Winner;
import thapisnu.Tideman.Model.Election;

@RestController
@RequestMapping("/winners")
public class WinnerController {

	private WinnerService winners;

    public WinnerController(WinnerService winners) {
		this.winners = winners;
    }

    @GetMapping("/{election_id}")
	public Winner show(@PathVariable int election_id) {
        return winners.getWinners(election_id);
    }

    @PostMapping()
    public void post(@RequestBody Election election) {
		winners.calculateWinner(election);
    }

}
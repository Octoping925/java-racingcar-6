package racingcar.config;

import racingcar.domain.race.RaceChecker;
import racingcar.domain.util.NumberGenerator;
import racingcar.domain.util.RandomNumberGenerator;
import racingcar.port.in.RacingCarInputPort;
import racingcar.port.in.console.RacingCarInputConsoleAdapter;
import racingcar.service.CarService;
import racingcar.service.RacingCarGameService;
import racingcar.usecase.RacingCarUseCase;
import racingcar.view.RacingCarView;

public class RacingCarConfiguration {
    private NumberGenerator numberGenerator() {
        int randomMinInclusive = 0;
        int randomMaxInclusive = 9;

        return new RandomNumberGenerator(randomMinInclusive, randomMaxInclusive);
    }

    private RaceChecker raceChecker() {
        return new RaceChecker();
    }

    private CarService carService(NumberGenerator generator) {
        return new CarService(generator);
    }

    private RacingCarGameService racingCarGameService(RaceChecker raceChecker) {
        return new RacingCarGameService(raceChecker);
    }


    private RacingCarView racingCarView() {
        return new RacingCarView();
    }

    private RacingCarInputPort racingCarInputPort() {
        return new RacingCarInputConsoleAdapter();
    }

    private RacingCarUseCase racingCarUseCase() {
        return new RacingCarUseCase(
                carService(numberGenerator()),
                racingCarGameService(raceChecker()),
                racingCarView(),
                racingCarInputPort()
        );
    }
}

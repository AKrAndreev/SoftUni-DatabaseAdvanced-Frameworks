package app.retake;

import app.retake.controllers.AnimalAidController;
import app.retake.controllers.AnimalController;
import app.retake.io.api.ConsoleIO;
import app.retake.io.api.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    private final FileIO fileIO;
    private final ConsoleIO consoleIO;
    private final AnimalAidController animalAidController;
    private final AnimalController animalController;

    @Autowired
    public Terminal(final FileIO fileIO,
                    final ConsoleIO consoleIO,
                    final AnimalAidController animalAidController,
                    final AnimalController animalController) {
        this.fileIO = fileIO;
        this.consoleIO = consoleIO;
        this.animalAidController = animalAidController;
        this.animalController = animalController;
    }

    @Override
    public void run(String... strings) {
        consoleIO.write(this.animalAidController
                .importDataFromJSON(fileIO.read(Config.ANIMAL_AIDS_IMPORT_JSON)));

        consoleIO.write(this.animalController
                .importDataFromJSON(fileIO.read(Config.ANIMALS_IMPORT_JSON)));
    }
}

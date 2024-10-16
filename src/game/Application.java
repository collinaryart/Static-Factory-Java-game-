package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.actors.AlienBug;
import game.actors.HuntsmanSpider;
import game.actors.Player;
import game.actors.SuspiciousAstronaut;
import game.ground.*;
import game.ground.tree.inheritree.PolymorphiaStageManager;
import game.ground.tree.inheritree.RefactorioStageManager;
import game.ground.tree.StageManager;
import game.ground.tree.inheritree.InheritreeSapling;
import game.items.Buyable;
import game.items.Theseus;
import game.items.ToiletPaperRoll;
import game.items.useables.EnergyDrink;
import game.items.useables.GoldPot;
import game.items.useables.PicklesJar;
import game.ground.ComputerTerminal;
import game.items.weapons.DragonSlayerSword;
import game.monologue.Astley;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Aleena Elizabeth
 *
 */
public class Application {

    /**
     * Main method to start game
     * @param args arguments
     */
    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new InheritreeSapling());
        List<String> parkingLot = Arrays.asList(
                ".......",
                ".#####.",
                ".#___#.",
                ".#___#.",
                ".##_##.",
                ".......",
                ".......",
                ".......",
                ".......",
                "......."
        );

        List<String> newMoon = Arrays.asList(
               "..........................~~~~",
               "..........................~~~~",
               "..........................~~~~",
               "~..........................~..",
               "~~...........#####............",
               "~~~..........#___#............",
               "~~~..........#___#............",
               "~~~..........##_##............",
               "~~~..................~~.......",
               "~~~~................~~~~......",
               "~~~~...............~~~~~......",
               "..~................~~~~.......",
               "....................~~........",
               ".............~~...............",
               "............~~~~.............."
       );
        List<String> map = Arrays.asList(
                "...~~~~.........~~~...........",
                "...~~~~.......................",
                "...~~~........................",
                "..............................",
                ".............#####............",
                ".............#___#...........~",
                ".............#___#..........~~",
                ".............##_##.........~~~",
                ".................~~........~~~",
                "................~~~~.......~~~",
                ".............~~~~~~~........~~",
                "......~.....~~~~~~~~.........~",
                ".....~~~...~~~~~~~~~..........",
                ".....~~~~~~~~~~~~~~~~........~",
                ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map); // Create GameMap objects from the lists of strings
        world.addGameMap(gameMap);

        GameMap newMoonMap = new GameMap(groundFactory, newMoon);
        world.addGameMap(newMoonMap);

        GameMap parkingLotMap = new GameMap(groundFactory, parkingLot);
        world.addGameMap(parkingLotMap);

        //gameMap terminal
        List<Buyable> gameMapBuyables = new ArrayList<>(Arrays.asList(
                new EnergyDrink(), new DragonSlayerSword(), new ToiletPaperRoll(), new Theseus(), new Astley()));
        ComputerTerminal gameMapComputerTerminal = new ComputerTerminal(gameMapBuyables);
        Location gameMapComputerTerminalLocation = gameMap.at(15,5);
        gameMapComputerTerminalLocation.setGround(gameMapComputerTerminal);
        String gameMapName = "Polymorphia";

        //parking lot terminal
        List<Buyable> parkingLotBuyables = new ArrayList<>(Arrays.asList(
                new EnergyDrink(), new DragonSlayerSword(), new ToiletPaperRoll(), new Theseus(), new Astley()));
        ComputerTerminal parkingLotComputerTerminal = new ComputerTerminal(parkingLotBuyables);
        Location parkingLotComputerTerminalLocation = parkingLotMap.at(3,2);
        parkingLotComputerTerminalLocation.setGround(parkingLotComputerTerminal);
        String parkingLotName = "Static Factory";

        //newMoonMap terminal
        List<Buyable> newMoonBuyables = new ArrayList<>(Arrays.asList(
                new EnergyDrink(), new DragonSlayerSword(), new ToiletPaperRoll(), new Theseus(), new Astley()));
        ComputerTerminal newMoonMapcomputerTerminal = new ComputerTerminal(newMoonBuyables);
        Location newMoonMapcomputerTerminalLocation = newMoonMap.at(15,5);
        newMoonMapcomputerTerminalLocation.setGround(newMoonMapcomputerTerminal);
        String newMoonName = "Refactorio";

        //inject the other terminals for gameMap
        gameMapComputerTerminal.addDestinations(parkingLotComputerTerminalLocation, parkingLotName);
        gameMapComputerTerminal.addDestinations(newMoonMapcomputerTerminalLocation, newMoonName);

        //inject the other terminals for parkingLot
        parkingLotComputerTerminal.addDestinations(gameMapComputerTerminalLocation,gameMapName);
        parkingLotComputerTerminal.addDestinations(newMoonMapcomputerTerminalLocation, newMoonName);

        //inject the other terminals for newMoon
        newMoonMapcomputerTerminal.addDestinations(gameMapComputerTerminalLocation, gameMapName);
        newMoonMapcomputerTerminal.addDestinations(parkingLotComputerTerminalLocation,parkingLotName);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        HuntsmanSpider huntsmanSpider = new HuntsmanSpider();
        float huntsmanSpiderRate = 0.05f;

        AlienBug alienBug = new AlienBug();
        float alientBugRate = 0.1f;

        SuspiciousAstronaut suspiciousAstronaut = new SuspiciousAstronaut();
        float suspiciousAstronautRate = 0.05f;

        gameMap.at(8,3).setGround(new Crater(huntsmanSpider, huntsmanSpiderRate));
        gameMap.at(4,12).setGround(new Crater(alienBug, alientBugRate));
        gameMap.at(22, 14).setGround(new Crater(suspiciousAstronaut, suspiciousAstronautRate));
        gameMap.at(12, 9).addItem(new GoldPot());
        gameMap.at(10, 9).addItem(new PicklesJar());
        gameMap.at(8, 9).addItem(new PicklesJar());gameMap.at(8, 9).addItem(new PicklesJar());

        //trees
        StageManager polymorphiaManager1 = new PolymorphiaStageManager();
        gameMap.at(9,5).setGround(polymorphiaManager1.getFirstStage());

        StageManager polymorphiaManager2 = new PolymorphiaStageManager();
        gameMap.at(10,11).setGround(polymorphiaManager2.getFirstStage());

        StageManager polymorphiaManager3 = new PolymorphiaStageManager();
        gameMap.at(2,11).setGround(polymorphiaManager3.getFirstStage());

        StageManager testRefactorioManger = new RefactorioStageManager();
        newMoonMap.at(18,2).setGround(testRefactorioManger.getFirstStage());



        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));
        player.addBalance(100);

        world.run();
    }
}

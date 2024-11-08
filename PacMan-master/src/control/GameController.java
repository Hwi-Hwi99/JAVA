package control;

import elements.Ball;
import elements.PowerPellet;
import elements.Blinky;
import elements.Cherry;
import elements.Clyde;
import elements.Element;
import elements.Enemy;
import elements.Fruit;
import elements.Inky;
import elements.PacMan;
import elements.Pinky;
import elements.Strawberry;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import scene.Stage;

public class GameController {
    
    private int mult = 0;

    // Desenhar todos os elementos do jogo
    public void drawAllElements(Stage scene, ArrayList<Element> elemArray, Graphics g, int control) {
        // Desenha cenario e bolinhas
        scene.paintScene(g);

        // Desenha outros elementos
        if (control != 0 && control != 4) {
            Iterator<Element> it = elemArray.listIterator();
            while (it.hasNext()) {
                it.next().autoDraw(g);
            }
        }
    }
    
    public boolean processAllElements(Stage scene, ArrayList<Element> e, ArrayList<Enemy> enemys) {
        if (e.isEmpty()) {
            return false;
        }

        // Pacmen
        PacMan pPacMan = (PacMan) e.get(0);

        // Inimigos
        Blinky blinky = (Blinky) enemys.get(0);
        Inky inky = (Inky) enemys.get(1);
        Pinky pinky = (Pinky) enemys.get(2);
        Clyde clyde = (Clyde) enemys.get(3);

        // Verifica colisao entre pacman e o cenario
        if (pPacMan.overlap(scene.getWalls())) {
            pPacMan.backToLastPosition();
            pPacMan.setMovBefDirection(pPacMan.getMovDirection());
            pPacMan.setMovDirection(PacMan.STOP);
            return false;
        }

        // Verifica colisão entre blinky e cenario
        if (blinky.overlap(scene.getWalls())) {

            // Setar movimento do blinky quando ocorre uma colisão
            blinky.backToLastPosition();
            setInvtMovDirectionBlinky(blinky, pPacMan);
        }

        // Verifica colisão entre pinky e cenario
        if (pinky.overlap(scene.getWalls())) {

            // Setar movimento do pinky quando ocorre uma colisão
            pinky.backToLastPosition();
            setInvtMovDirectionPinky(pinky);

            // Se houve colisão, entao pinky passa para estado aleatorio
            pinky.setStateDirection(Pinky.MOVE_ALEAT);
        }

        // Verifica colisão entre inky e cenario
        if (inky.overlap(scene.getWalls())) {

            // Setar movimento do pinky quando ocorre uma colisão
            inky.backToLastPosition();
            setInvtMovDirectionInky(inky);
        }
        
        //  Verifica colisão entre inky e cenario
        if (clyde.overlap(scene.getWalls())) {
            
            // Setar movimento do clyde quando ocorre uma colisão
            clyde.backToLastPosition();
            setInvMovDirectionClyde(clyde);
        }
        
        // Verifica colisao entre as bolinhas e pacman
        Iterator<Ball> it = scene.getBalls().listIterator();
        while (it.hasNext()) {
            if (pPacMan.overlapBall(it.next())) {
                it.remove();
                pPacMan.scorePoints(10);
                break;
            }
        }
        
        Iterator<PowerPellet> it2 = scene.getPowerPellet().listIterator();
        while (it2.hasNext()) {
            if (pPacMan.overlapBall(it2.next())) {
                mult = 1;
                pPacMan.scorePoints(50);
                it2.remove();
                blinky.setState(Enemy.CHASE); //coloca em vulnerável
                inky.setState(Enemy.CHASE);
                pinky.setState(Enemy.CHASE);
                clyde.setState(Enemy.CHASE);
                TimerTask vulnerable = new TimerTask() {
                    @Override
                    public void run() { //coloca em mortal de novo
                        if (blinky.getState() == Enemy.CHASE) {
                            blinky.setState(Enemy.HOUSE);
                        }
                        if (inky.getState() == Enemy.CHASE) {
                            inky.setState(Enemy.HOUSE);
                        }
                        if (pinky.getState() == Enemy.CHASE) {
                            pinky.setState(Enemy.HOUSE);
                        }
                        if (clyde.getState() == Enemy.CHASE) {
                            clyde.setState(Enemy.HOUSE);
                        }
                    }
                };
                Timer timer = new Timer();
                timer.schedule(vulnerable, 7000);
                break;
            }
        }
        
        Iterator<PowerPellet> it2_power = scene.getPowerPellet().listIterator();
        while (it2_power.hasNext()) {
            if (pPacMan.overlapBall(it2_power.next())) {
                it2_power.remove();
                blinky.setState(2); //coloca em vulnerável
                inky.setState(2);
                pinky.setState(2);
                clyde.setState(2);
                TimerTask vulnerable = new TimerTask() {
                    @Override
                    public void run() { //coloca em mortal de novo
                        if (blinky.getState() == 2) {
                            blinky.setState(1);
                        }
                        if (inky.getState() == 2) {
                            inky.setState(1);
                        }
                        if (pinky.getState() == 2) {
                            pinky.setState(1);
                        }
                        if (clyde.getState() == 2) {
                            clyde.setState(1);
                        }
                    }
                };
                Timer timer = new Timer();
                timer.schedule(vulnerable, 7000);
                break;
            }
        }

        // Variavel que detecta que se houve uma colisão entre pacman e inimigo
        boolean aux = false;
        
        Element eTemp;

        // Verifica colisao entre PacMan e outros elementos
        for (int i = 1; i < e.size(); i++) {
            eTemp = e.get(i);
            if (!eTemp.isTransposable() && pPacMan.overlap(eTemp)) {

                // Se elemento for um inimigo
                if (eTemp instanceof Enemy) {
                    switch (((Enemy) eTemp).getState()) {
                        case 1:
                            aux = true;
                            pPacMan.backToLastPosition();
                            pPacMan.setMovDirection(PacMan.STOP);
                            break;
                        case 2:
                            pPacMan.scorePoints(200 * mult);
                            if (eTemp instanceof Blinky) {
                                blinky.setState(3);
                            }
                            if (eTemp instanceof Inky) {
                                inky.setState(3);
                            }
                            if (eTemp instanceof Pinky) {
                                pinky.setState(3);
                            }
                            if (eTemp instanceof Clyde) {
                                clyde.setState(3);
                            }
                            mult *= 2;
                            break;
                        default:
                            break;
                    }
                } else if (eTemp instanceof Fruit) { //verifica se o elemento é fruta e dá os pontos
                    if (eTemp instanceof Cherry) {
                        pPacMan.scorePoints(100);
                    }
                    if (eTemp instanceof Strawberry) {
                        pPacMan.scorePoints(300);
                    }
                    e.remove(eTemp);
                } else {
                    e.remove(eTemp);
                }
            }
        }
        
        if (pPacMan.getScoreAux() >= 10000) {
            pPacMan.resetScore();
            pPacMan.addLife();
        }

        // Movimenta o pacman
        pPacMan.move();

        // Movimentar inimigos
        blinky.move();
        pinky.move();
        inky.move();
        clyde.move();
        
        return aux;
    }

    // Setar movimento do blinky
    private void setInvtMovDirectionBlinky(Enemy enemy, PacMan pPacMan) {
        
        // Definir uma nova direção para o blinky
        switch (enemy.getMovDirection()) {            
            case Enemy.MOVE_LEFT:
                if (pPacMan.getPos().getX() > enemy.getPos().getX()) {
                    enemy.setMoveDirection(Enemy.MOVE_DOWN);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_UP);
                }
                break;
            
            case Enemy.MOVE_RIGHT:
                if (pPacMan.getPos().getX() > enemy.getPos().getX()) {
                    enemy.setMoveDirection(Enemy.MOVE_DOWN);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_UP);
                }
                break;
            
            case Enemy.MOVE_DOWN:
                if (pPacMan.getPos().getY() > enemy.getPos().getY()) {
                    enemy.setMoveDirection(Enemy.MOVE_RIGHT);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_LEFT);
                }
                break;
            
            case Enemy.MOVE_UP:
                if (pPacMan.getPos().getY() > enemy.getPos().getY()) {
                    enemy.setMoveDirection(Enemy.MOVE_RIGHT);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_LEFT);
                }
                break;
        }
    }

    // Setar movimento do pinky
    private void setInvtMovDirectionPinky(Enemy enemy) {
        
        int aux = (int) (Math.random() * 10) % 2;

        // Definir uma nova direção para o pinky
        switch (enemy.getMovDirection()) {
            case Enemy.MOVE_LEFT:
                if (aux == 0) {
                    enemy.setMoveDirection(Enemy.MOVE_UP);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_DOWN);
                }
                break;
            
            case Enemy.MOVE_RIGHT:
                if (aux == 0) {
                    enemy.setMoveDirection(Enemy.MOVE_UP);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_DOWN);
                }
                break;
            
            case Enemy.MOVE_DOWN:
                if (aux == 0) {
                    enemy.setMoveDirection(Enemy.MOVE_LEFT);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_RIGHT);
                }
                break;
            
            case Enemy.MOVE_UP:
                if (aux == 0) {
                    enemy.setMoveDirection(Enemy.MOVE_UP);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_DOWN);
                }
                break;
        }
    }
    
    // Movimentar clyde
    private void setInvMovDirectionClyde(Enemy enemy) {
        int aux = (int) (Math.random() * 10) % 2;

        // Definir uma nova direção para o pinky
        switch (enemy.getMovDirection()) {
            case Enemy.MOVE_LEFT:
                if (aux == 0) {
                    enemy.setMoveDirection(Enemy.MOVE_UP);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_DOWN);
                }
                break;
            
            case Enemy.MOVE_RIGHT:
                if (aux == 0) {
                    enemy.setMoveDirection(Enemy.MOVE_UP);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_DOWN);
                }
                break;
            
            case Enemy.MOVE_DOWN:
                if (aux == 0) {
                    enemy.setMoveDirection(Enemy.MOVE_LEFT);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_RIGHT);
                }
                break;
            
            case Enemy.MOVE_UP:
                if (aux == 0) {
                    enemy.setMoveDirection(Enemy.MOVE_UP);
                } else {
                    enemy.setMoveDirection(Enemy.MOVE_DOWN);
                }
                break;
        }
    }

    // Sertar movimento do inky
    private void setInvtMovDirectionInky(Inky inky) {
        
        int rand = (int) (Math.random() * 10) % 2;
        
        switch (inky.getMovDirection()) {
            case Inky.MOVE_LEFT:
                if (rand == 0) {
                    inky.setMoveDirection(Inky.MOVE_UP);
                } else {
                    inky.setMoveDirection(Inky.MOVE_DOWN);
                }
                break;
            
            case Inky.MOVE_RIGHT:
                if (rand == 0) {
                    inky.setMoveDirection(Inky.MOVE_UP);
                } else {
                    inky.setMoveDirection(Inky.MOVE_DOWN);
                }
                break;
            
            case Inky.MOVE_UP:
                if (rand == 0) {
                    inky.setMoveDirection(Inky.MOVE_LEFT);
                } else {
                    inky.setMoveDirection(Inky.MOVE_RIGHT);
                }
                break;
            
            case Inky.MOVE_DOWN:
                if (rand == 0) {
                    inky.setMoveDirection(Inky.MOVE_LEFT);
                } else {
                    inky.setMoveDirection(Inky.MOVE_RIGHT);
                }
                break;
        }
    }
}

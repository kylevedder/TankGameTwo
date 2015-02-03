/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kylevedder.com.github.slickstates;

import kylevedder.com.github.gui.GUIRotatingLogo;
import kylevedder.com.github.main.MainApp;
import kylevedder.com.github.menu.MainMenu;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Kyle
 */
public class SlickStateMainMenu extends BasicGameState
{

    public static final int ID = 0;
    
    private final int LOGO_NUM_FRAMES = 4;
    private final int LOGO_UPDATE_MILLIS = 2000;
    private final int LOGO_Y_POS = 100;
    
    private MainMenu menu = null;
    private GUIRotatingLogo logo = null;        
    
    @Override
    public int getID()
    {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException
    {
        System.out.println("Init MainMenu");
        this.logo = new GUIRotatingLogo("images/title/full.png", "images/title/wire_frame.png", LOGO_NUM_FRAMES, LOGO_UPDATE_MILLIS, LOGO_Y_POS);
        this.menu = new MainMenu(container, game);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
    {        
        menu.render(g, true);
        logo.render(container);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
        MainApp.musicPlayer.playMenuMusic();
        logo.update(delta);
        menu.update();
        MainApp.screenManager.update(container.getInput());
    }
    
}

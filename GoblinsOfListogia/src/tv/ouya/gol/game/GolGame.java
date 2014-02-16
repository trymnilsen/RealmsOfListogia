package tv.ouya.gol.game;

import java.util.ArrayList;

import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import tv.ouya.console.api.OuyaController;
import tv.ouya.gol.Screen;
import tv.ouya.gol.Ouya.OuyaControllUtil;
import tv.ouya.gol.Ouya.OuyaGame;

public class GolGame extends OuyaGame{
	
	BattleScreen battleScreen;
	SparseArray<Player> players;
	public GolGame()
	{
		players = new SparseArray<Player>();
	}
	@Override
	public Screen getInitScreen() {
		
		if(battleScreen == null)
		{
			battleScreen = new BattleScreen(this);
		}
		// TODO Auto-generated method stub
		return battleScreen;
	}
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean handled = false;
        synchronized (pauseInput) {
            handled = OuyaController.onKeyDown(keyCode, event);
            CreatePlayer(event.getDeviceId());
        }

        return handled || super.onKeyDown(keyCode, event);
    }
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean handled = false;
        synchronized (pauseInput) {
            handled = OuyaController.onKeyUp(keyCode, event);
        }
        return handled || super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        boolean handled = false;
        synchronized (pauseInput) {
            handled = OuyaController.onGenericMotionEvent(event);
        }

        OuyaController c = OuyaController.getControllerByDeviceId(event.getDeviceId());
        if (c != null) {
            if (OuyaControllUtil.isStickNotCentered(
                    c.getAxisValue(OuyaController.AXIS_LS_X),
                    c.getAxisValue(OuyaController.AXIS_LS_Y))) {
                // Create the player if necessary
                CreatePlayer(event.getDeviceId());
            }
        }

        return handled || super.onGenericMotionEvent(event);
    }

    private void CreatePlayer(int deviceId) {
        int playerNum = OuyaController.getPlayerNumByDeviceId(deviceId);
        //Log.d("Player","PlayerNum for device: "+playerNum);
        if (playerNum < 0) {
        	return;
        }
        if(players.get(playerNum)==null)
        {
        	Player newPlayer = new Player(playerNum);
        	players.append(playerNum, newPlayer);
        	newPlayer = new Player(playerNum);
        	
        	Log.d("Player", "Adding player nr:"+playerNum);
        }

    }
	public SparseArray<Player> getPlayers() {
		return players;
	}



}

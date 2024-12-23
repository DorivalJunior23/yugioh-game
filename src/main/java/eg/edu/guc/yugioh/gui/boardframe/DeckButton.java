package eg.edu.guc.yugioh.gui.boardframe;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.configsGlobais.Logger;

@SuppressWarnings("serial")
public class DeckButton extends JButton {
	private static ImageIcon deck = new ImageIcon("images/AttackMode.png");
	private boolean active;

	public DeckButton(boolean active) {
		super(deck);
		this.active = active;
		setHorizontalTextPosition(SwingConstants.CENTER);
		setFont(new Font("", Font.ITALIC | Font.BOLD, 40));
		setForeground(java.awt.Color.WHITE);
		setPreferredSize(new Dimension(CardButton.getDimension('W'),150));
		updateDeck();
		validate();
	}

	public void updateDeck(){

		Logger.logs().info("DeckButton - updateDeck active: " + active);

		if(active)
			setText(""+Card.getBoard().getActivePlayer().getField().getDeck().getDeck().size());
		else 
			setText(""+Card.getBoard().getOpponentPlayer().getField().getDeck().getDeck().size());
	}
}
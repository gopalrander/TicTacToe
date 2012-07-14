package gopal.rander;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Tic_Tac_Toe extends Activity {
    /** Called when the activity is first created. */
        int red = 0xffff0000;
        int green = 0xff00ff00;
        int white = 0xffffffff;
        int black = 0x00000000;
        int gray = 0xff888888;
        public static int count=0;
        public boolean end=false;
        public Button last;
        public void graybck(Button b[]){
        	for(int i=0;i<=8;i++){
            	b[i].getBackground().setColorFilter(gray, PorterDuff.Mode.XOR);
        	}    
        }
        
        public void btnEn(Button b[],Boolean val){
        	for (int i=0;i<=8;i++)
        	{	b[i].setEnabled(val);
        	}
        }
        
        public void but(Button b, TextView tv) {
                if(b.isEnabled()){
                        if(count%2==0){
                                b.setText("X");
                                tv.setText ("Turn - O");
                                b.setTextColor(red);
                        }       
                        else{
                                b.setText("O");
                                tv.setText ("Turn - X");
                                b.setTextColor(green);
                        }
                        count++;
                        b.setEnabled(false);
                        last = b;
                }
        }
        
        public void display(Button b1, Button b2, Button b3){
        	b1.getBackground().setColorFilter(white, PorterDuff.Mode.XOR);
            b2.getBackground().setColorFilter(white, PorterDuff.Mode.XOR);
            b3.getBackground().setColorFilter(white, PorterDuff.Mode.XOR);
        }
        
        public void logic(Button b[], AlertDialog alertDialog){
        if((b[0].getText() == b[1].getText())&& (b[0].getText()== b[2].getText())&& !b[0].isEnabled()&& !b[1].isEnabled()&& !b[2].isEnabled()){
        	alertDialog.setMessage("Player with " + b[0].getText() + " Won !!\nPlay Agian?");
                display(b[0],b[1],b[2]);
                end=true;
                
        }
        if((b[3].getText() == b[4].getText())&& (b[3].getText()== b[5].getText())&& !b[3].isEnabled()&& !b[4].isEnabled()&& !b[5].isEnabled()){
        	alertDialog.setMessage("Player with " + b[3].getText() + " Won !!\nPlay Agian?");
                display(b[3],b[4],b[5]);
                end=true;
        }
        if((b[6].getText() == b[7].getText())&& (b[6].getText()== b[8].getText())&& !b[6].isEnabled()&& !b[7].isEnabled()&& !b[8].isEnabled()){
        	alertDialog.setMessage("Player with " + b[6].getText() + " Won !!\nPlay Agian?");
                display(b[6],b[7],b[8]);
                end=true;
        }
        if((b[0].getText() == b[4].getText())&& (b[0].getText()== b[8].getText())&& !b[0].isEnabled()&& !b[4].isEnabled()&& !b[8].isEnabled()){
        	alertDialog.setMessage("Player with " + b[0].getText() + " Won !!\nPlay Agian?");
                display(b[0],b[4],b[8]);
                end=true;
        }
        if((b[2].getText() == b[4].getText())&& (b[2].getText()== b[6].getText())&& !b[2].isEnabled()&& !b[4].isEnabled()&& !b[6].isEnabled()){
        	alertDialog.setMessage("Player with " + b[2].getText() + " Won !!\nPlay Agian?");
                display(b[2],b[4],b[6]);
                end=true;
        }
        if((b[0].getText() == b[3].getText())&& (b[0].getText()== b[6].getText())&& !b[0].isEnabled()&& !b[3].isEnabled()&& !b[6].isEnabled()){
        	alertDialog.setMessage("Player with " + b[0].getText() + " Won !!\nPlay Agian?");
                display(b[0],b[3],b[6]);
                end=true;
        }
        if((b[1].getText() == b[4].getText())&& (b[1].getText()== b[7].getText())&& !b[1].isEnabled()&& !b[4].isEnabled()&& !b[7].isEnabled()){
        	alertDialog.setMessage("Player with " + b[1].getText() + " Won !!\nPlay Agian?");
                display(b[1],b[4],b[7]);
                end=true;
        }
        if((b[2].getText() == b[5].getText())&& (b[2].getText()== b[8].getText())&& !b[2].isEnabled()&& !b[8].isEnabled()&& !b[5].isEnabled()){
        	alertDialog.setMessage("Player with " + b[2].getText() + " Won !!\nPlay Agian?");
                display(b[2],b[5],b[8]);
                end=true;
        }
        
        if(!end && count==9){
        	alertDialog.setMessage("Game ended in Draw..\nPlay Agian?");
        	alertDialog.setTitle("Game Draw.");
        	alertDialog.show();
        }
        	
        if(end){
                btnEn(b,false);
                alertDialog.setTitle("Game Ends.");
                alertDialog.show();
        }
        return;
        }
        
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Button b[] = new Button[9];
        count=0;
        b[0] = (Button) this.findViewById(R.id.zero);
        b[1] = (Button) this.findViewById(R.id.one);
        b[2] = (Button) this.findViewById(R.id.two);
        b[3] = (Button) this.findViewById(R.id.three);
        b[4] = (Button) this.findViewById(R.id.four);
        b[5] = (Button) this.findViewById(R.id.five);
        b[6] = (Button) this.findViewById(R.id.six);
        b[7] = (Button) this.findViewById(R.id.seven);
        b[8] = (Button) this.findViewById(R.id.eight);
        graybck(b);
        final TextView tv = (TextView) this.findViewById(R.id.textView1);
        
        final Button undo = (Button) this.findViewById(R.id.undo);
        Button exit = (Button) this.findViewById(R.id.exit);
        undo.setEnabled(false);
        
        final AlertDialog.Builder exit1 = new AlertDialog.Builder(this);
        exit1.setCancelable(false);
        exit1.setMessage("Are you sure to leave the game?");
        exit1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        //final Intent intent = new Intent(Tic_Tac_Toe.this, Try1.class);
        exit1.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
        
        final AlertDialog exitDialog = exit1.create();
        exitDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams WMLP = exitDialog.getWindow().getAttributes();


	    WMLP.x = 100;   //x position
	    WMLP.y = 150;   //y position
	
	    exitDialog.getWindow().setAttributes(WMLP);

        
        final AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(this);
        alertDialog1.setCancelable(false);
        alertDialog1.setPositiveButton("Play Again",new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				btnEn(b,true);
				for (int i=0;i<=8;i++)
				{	b[i].setText(" ");
				}
				
                count = 0;
                end =false;
                graybck(b);
                undo.setEnabled(false);
                tv.setText ("Turn - X");
		
			}
		});
        
        alertDialog1.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				finish();
			}
		});
        final AlertDialog alertDialog = alertDialog1.create();
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams WMLP1 = alertDialog.getWindow().getAttributes();


	    WMLP1.x = 0;   //x position
	    WMLP1.y = 150;   //y position
	    
	    
	    
	
	    alertDialog.getWindow().setAttributes(WMLP1);

        b[0].setOnTouchListener(new View.OnTouchListener() {
                        
						public boolean onTouch(View v, MotionEvent event) {
							// TODO Auto-generated method stub
							undo.setEnabled(true);
							but(b[0], tv);
                            logic(b,alertDialog);
                            //startActivity(intent);
							return false;
						}
                });
        
        b[1].setOnTouchListener(new View.OnTouchListener() {
            
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				undo.setEnabled(true);
				but(b[1], tv);
                logic(b,alertDialog);
				return false;
			}
        });
        
        b[2].setOnTouchListener(new View.OnTouchListener() {
            
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				undo.setEnabled(true);
				but(b[2],tv);
                logic(b,alertDialog);
				return false;
			}
        });        
        
        b[3].setOnTouchListener(new View.OnTouchListener() {
            
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				undo.setEnabled(true);
				but(b[3],tv);
                logic(b,alertDialog);
				return false;
			}
        });
        
        b[4].setOnTouchListener(new View.OnTouchListener() {
            
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				undo.setEnabled(true);
				but(b[4],tv);
                logic(b,alertDialog);
				return false;
			}
        });
        
        b[5].setOnTouchListener(new View.OnTouchListener() {
            
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				undo.setEnabled(true);
				but(b[5],tv);
                logic(b,alertDialog);
				return false;
			}
        });
        
        b[6].setOnTouchListener(new View.OnTouchListener() {
            
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				undo.setEnabled(true);
				but(b[6],tv);
                logic(b,alertDialog);
				return false;
			}
        });
        
        b[7].setOnTouchListener(new View.OnTouchListener() {
            
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				undo.setEnabled(true);
				but(b[7],tv);
                logic(b,alertDialog);
				return false;
			}
        });
        
        b[8].setOnTouchListener(new View.OnTouchListener() {
            
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				undo.setEnabled(true);
				but(b[8],tv);
                logic(b,alertDialog);
				return false;
			}
        });
        
       exit.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			exitDialog.show();
		}
       });
       
       undo.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			count--;
			if (count%2==1)
				tv.setText ("Turn - O");
			else
				tv.setText ("Turn - X");
			last.setEnabled(true);
			last.setText(" ");
			undo.setEnabled(false);
		}
       });
        }
}
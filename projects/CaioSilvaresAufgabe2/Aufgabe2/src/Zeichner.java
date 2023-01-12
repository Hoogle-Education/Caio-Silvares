import de.tub.ise.graphics.Painter;

public class Zeichner {

    public static void main(String[] args){
        Painter.show();

        for(int i = 0; i < Painter.shroom.length; i++){
            for(int j = 0; j < Painter.shroom[i].length; j++){

                Painter.paint(i, j, Painter.shroom[j][i]);
            }
        }
    }
}

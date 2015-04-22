package model.kindling;

/**
 * Created by Jay on 4/21/2015.
 */
public class Range {
    private int start, finish;

    public Range(){ //no arguments
        start = 0;
        finish = 0;
    }

    public Range(int _start, int _finish){
        this.start = _start;
        this.finish = _finish;
    }

    private void setStart(int setter){
        start = setter;
    }

    private void setFinish(int setter){
        finish = setter;
    }

    private void setStartFinish(int _start, int _finish){
        start  = _start;
        finish = _finish;
    }

    private int getStart(){
        return start;
    }

    private int getFinish(){
        return finish;
    }
}

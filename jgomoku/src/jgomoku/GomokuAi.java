 /*
  *Copyright 2008 Cristian Achim
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing,
  * software distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  *
  */
package jgomoku;

public class GomokuAi implements Runnable{
    private char[][] boardPosition;
    private boolean blackToMove;
    private GameController gc;
    private Move bestMove;
    private int searchDepth;

    GomokuAi(char[][] position , boolean blackToMove , GameController gc , int depth){
        boardPosition=position;
        this.blackToMove=blackToMove;
        this.gc=gc;
        this.searchDepth=depth;
    }

    @Override
    public void run() {
        bestMove=(new AlphaBetaNode(boardPosition , searchDepth)).getBestMove();

        if(bestMove == null){
            return;
        }

        gc.sendPlayerInput("move " + bestMove.row + " " + bestMove.column);
    }
    
}

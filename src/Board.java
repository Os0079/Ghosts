
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author smnsl
 */
public class Board extends JComponent
{

        public int turnCounter = 0;
        private static Image NULL_IMAGE = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);

        private final int Square_Width = 65;
        public ArrayList<GoodGhost> GoodGhosts;
        public ArrayList<EvilGhost> Black_Pieces;

        public ArrayList<DrawingShape> Static_Shapes;
        public ArrayList<DrawingShape> EvilGhosts;

        public Ghost Active_Piece;

        private final int rows = 8;
        private final int cols = 8;
        private Integer[][] BoardGrid;
        private String board_file_path = "images" + File.separator + "6x6.png";
        private String active_square_file_path = "images" + File.separator + "active_square.png";

        public void initGrid() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    BoardGrid[i][j] = 0;
                }
            }

            //Image white_piece = loadImage("images/white_pieces/" + piece_name + ".png");
            //Image black_piece = loadImage("images/black_pieces/" + piece_name + ".png");  


        }

        public Board() {

            BoardGrid = new Integer[rows][cols];
            Static_Shapes = new ArrayList();
            EvilGhosts = new ArrayList();
            GoodGhosts = new ArrayList();
            Black_Pieces = new ArrayList();

            initGrid();

            this.setBackground(new Color(37, 13, 84));
            this.setPreferredSize(new Dimension(520, 520));
            this.setMinimumSize(new Dimension(100, 100));
            this.setMaximumSize(new Dimension(1000, 1000));

            this.addMouseListener(mouseAdapter);
            this.addComponentListener(componentAdapter);
            this.addKeyListener(keyAdapter);

            this.setVisible(true);
            this.requestFocus();
            drawBoard();
        }

        private void drawBoard() {
            EvilGhosts.clear();
            Static_Shapes.clear();
            //initGrid();

            Image board = loadImage(board_file_path);
            Static_Shapes.add(new DrawingImage(board, new Rectangle2D.Double(0, 0, board.getWidth(null), board.getHeight(null))));
            if (Active_Piece != null) {
                Image active_square = loadImage("images" + File.separator + "active_square.png");
                Static_Shapes.add(new DrawingImage(active_square, new Rectangle2D.Double(Square_Width * Active_Piece.getCoords().getX(), Square_Width * Active_Piece.getCoords().getY(), active_square.getWidth(null), active_square.getHeight(null))));
            }
            for (int i = 0; i < GoodGhosts.size(); i++) {
                int COL = (int) GoodGhosts.get(i).getCoords().getX();
                int ROW = (int) GoodGhosts.get(i).getCoords().getY();
                Image piece = loadImage("images" + File.separator + "white_pieces" + File.separator + GoodGhosts.get(i).getFilePath());
                EvilGhosts.add(new DrawingImage(piece, new Rectangle2D.Double(Square_Width * COL, Square_Width * ROW, piece.getWidth(null), piece.getHeight(null))));
            }
            for (int i = 0; i < Black_Pieces.size(); i++) {
                int COL = (int) Black_Pieces.get(i).getCoords().getX();
                int ROW = (int) Black_Pieces.get(i).getCoords().getY();
                Image piece = loadImage("images" + File.separator + "black_pieces" + File.separator + Black_Pieces.get(i).getFilePath());
                EvilGhosts.add(new DrawingImage(piece, new Rectangle2D.Double(Square_Width * COL, Square_Width * ROW, piece.getWidth(null), piece.getHeight(null))));
            }
            this.repaint();
        }

        public Ghost getPiece(int x, int y) {
            for (Ghost p : GoodGhosts) {
                if (p.getCoords().getX() == x && p.getCoords().getY() == y) {
                    return p;
                }
            }
            for (Ghost p : Black_Pieces) {
                if (p.getCoords().getX() == x && p.getCoords().getY() == y) {
                    return p;
                }
            }
            return null;
        }

        private MouseAdapter mouseAdapter = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int d_X = e.getX();
                int d_Y = e.getY();
                int Clicked_Row = d_Y / Square_Width;
                int Clicked_Column = d_X / Square_Width;
                boolean is_whites_turn = true;
                if (turnCounter % 2 == 1) {
                    is_whites_turn = false;
                }

                Ghost clicked_piece = getPiece(Clicked_Column, Clicked_Row);

                if (Active_Piece == null && clicked_piece != null
                        && ((is_whites_turn && clicked_piece.isWhite()) || (!is_whites_turn && clicked_piece.isBlack()))) {
                    Active_Piece = clicked_piece;
                } else if (Active_Piece != null && Active_Piece.getCoords().getX() == Clicked_Column && Active_Piece.getCoords().getY() == Clicked_Row) {
                    Active_Piece = null;
                } else if (Active_Piece != null && Active_Piece.canMove(Clicked_Column, Clicked_Row)
                        && ((is_whites_turn && Active_Piece.isWhite()) || (!is_whites_turn && Active_Piece.isBlack()))) {
                    // if piece is there, remove it so we can be there
                    if (clicked_piece != null) {
                        if (clicked_piece.isWhite()) {
                            GoodGhosts.remove(clicked_piece);
                        } else {
                            Black_Pieces.remove(clicked_piece);
                        }
                    }
                    // do move
                    Active_Piece.setX(Clicked_Column);
                    Active_Piece.setY(Clicked_Row);

                    // if piece is a pawn set has_moved to true
                    if (Active_Piece.getClass().equals(Pawn.class)) {
                        Pawn castedPawn = (Pawn) (Active_Piece);
                        castedPawn.setHasMoved(true);
                    }

                    Active_Piece = null;
                    turnCounter++;
                }

                drawBoard();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
            }

        };

        private void adjustShapePositions(double dx, double dy) {

            Static_Shapes.get(0).adjustPosition(dx, dy);
            this.repaint();

        }

        private Image loadImage(String imageFile) {
            try {
                return ImageIO.read(new File(imageFile));
            } catch (IOException e) {
                return NULL_IMAGE;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            drawBackground(g2);
            drawShapes(g2);
        }

        private void drawBackground(Graphics2D g2) {
            g2.setColor(getBackground());
            g2.fillRect(0, 0, getWidth(), getHeight());
        }

        private void drawShapes(Graphics2D g2) {
            for (DrawingShape shape : Static_Shapes) {
                shape.draw(g2);
            }
            for (DrawingShape shape : EvilGhosts) {
                shape.draw(g2);
            }
        }

        private ComponentAdapter componentAdapter = new ComponentAdapter() {

            @Override
            public void componentHidden(ComponentEvent e) {

            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentResized(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }
        };

        private KeyAdapter keyAdapter = new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyTyped(KeyEvent e) {

            }
        };

    }

    interface DrawingShape {

        boolean contains(Graphics2D g2, double x, double y);

        void adjustPosition(double dx, double dy);

        void draw(Graphics2D g2);
    }

    class DrawingImage implements DrawingShape {

        public Image image;
        public Rectangle2D rect;

        public DrawingImage(Image image, Rectangle2D rect) {
            this.image = image;
            this.rect = rect;
        }

        @Override
        public boolean contains(Graphics2D g2, double x, double y) {
            return rect.contains(x, y);
        }

        @Override
        public void adjustPosition(double dx, double dy) {
            rect.setRect(rect.getX() + dx, rect.getY() + dy, rect.getWidth(), rect.getHeight());
        }

        @Override
        public void draw(Graphics2D g2) {
            Rectangle2D bounds = rect.getBounds2D();
            g2.drawImage(image, (int) bounds.getMinX(), (int) bounds.getMinY(), (int) bounds.getMaxX(), (int) bounds.getMaxY(),
                    0, 0, image.getWidth(null), image.getHeight(null), null);
        }
    
}

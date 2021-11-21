package com.example.memory;

public class Position {

    public int x;
    public int y;

    public Position(int i, int j)
    {
        x = i;
        y = j;
    }


    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
}

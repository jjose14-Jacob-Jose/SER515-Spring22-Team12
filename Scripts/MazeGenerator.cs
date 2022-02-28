using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;

[Flags]
public enum ObstacleState
{
    LEFT = 1, 
    RIGHT = 2,
    UP = 4,
    DOWN = 8,
    VISITED=128,
}

public struct Position
{
    public int X;
    public int Y;
}

public struct Neighbour
{
    public Position Position;
    public ObstacleState SharedWall;
}

public static class MazeGenerator
{
    public static ObstacleState[,] Generate(int width, int height)
    {
        ObstacleState[,] maze = new ObstacleState[width, height];
        ObstacleState initial = ObstacleState.RIGHT | ObstacleState.LEFT | ObstacleState.UP | ObstacleState.DOWN;

        for (int i = 0; i < width; i++) { 
        for(int j=0; j<height; j++)
            {
                maze[i, j] = initial;
            }
        }

       return CreateMaze(maze, width, height);
    }

    
    private static List<Neighbour> GetUnvisitedNeighbours(Position p, ObstacleState[,] maze, int width, int height)
    {
        var list = new List<Neighbour>();

       if (p.X > 0) 
        {
            if (!maze[p.X - 1, p.Y].HasFlag(ObstacleState.VISITED))
            {

                list.Add(new Neighbour
                {
                    Position = new Position
                    {
                        X = p.X - 1,
                        Y = p.Y
                    },
                    SharedWall = ObstacleState.LEFT
                });
            }
        }

        if (p.Y > 0) 
        {
            if (!maze[p.X, p.Y - 1].HasFlag(ObstacleState.VISITED))
            {
                list.Add(new Neighbour
                {
                    Position = new Position
                    {
                        X = p.X,
                        Y = p.Y - 1
                    },
                    SharedWall = ObstacleState.DOWN
                });
            }
        }

        if (p.Y < height - 1) 
        {
            if (!maze[p.X, p.Y + 1].HasFlag(ObstacleState.VISITED))
            {
                list.Add(new Neighbour
                {
                    Position = new Position
                    {
                        X = p.X,
                        Y = p.Y + 1
                    },
                    SharedWall = ObstacleState.UP
                });
            }
        }

        if (p.X < width - 1) 
        {
            if (!maze[p.X + 1, p.Y].HasFlag(ObstacleState.VISITED))
            {
                list.Add(new Neighbour
                {
                    Position = new Position
                    {
                        X = p.X + 1,
                        Y = p.Y
                    },
                    SharedWall = ObstacleState.RIGHT
                });
            }
        }

        return list;
    }


    private static ObstacleState[,] CreateMaze(ObstacleState[,] maze, int width, int height)
    {

        var rng = new System.Random();
        var positionStack = new Stack<Position>();
        var position = new Position { X = rng.Next(0, width), Y = rng.Next(0, height) };

        maze[position.X, position.Y] |= ObstacleState.VISITED;
        positionStack.Push(position);

        while (positionStack.Count > 0)
        {
            var current = positionStack.Pop();
            var neighbours = GetUnvisitedNeighbours(current, maze, width, height);

            if (neighbours.Count > 0)
            {
                positionStack.Push(current);

                var randIndex = rng.Next(0, neighbours.Count);
                var randomNeighbour = neighbours[randIndex];

                var nPosition = randomNeighbour.Position;
                maze[current.X, current.Y] &= ~randomNeighbour.SharedWall;
                maze[nPosition.X, nPosition.Y] &= ~AnotherWall(randomNeighbour.SharedWall);
                maze[nPosition.X, nPosition.Y] |= ObstacleState.VISITED;

                positionStack.Push(nPosition);
            }
        }

        return maze;
    }

    private static ObstacleState AnotherWall(ObstacleState wall)
    {

        if (wall.Equals(ObstacleState.RIGHT)) {
            return ObstacleState.LEFT;
        }
        else if (wall.Equals(ObstacleState.LEFT))
        {
            return ObstacleState.RIGHT;
        }
        else if (wall.Equals(ObstacleState.UP))
        {
            return ObstacleState.DOWN;
        }
        else if (wall.Equals(ObstacleState.DOWN))
        {
            return ObstacleState.UP;
        }

        else {
            return ObstacleState.LEFT;
        }
    }
}

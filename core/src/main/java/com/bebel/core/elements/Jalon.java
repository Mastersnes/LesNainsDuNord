package com.bebel.core.elements;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Jalon {
    protected Jalon up, down, left, right;
    protected final Vector2 position = new Vector2();

    public Jalon(final Vector2 position) {this(position.x, position.y);}
    public Jalon(final float x, final float y) {position.set(x, y);}

    public float x() {return position.x;}
    public float y() {return position.y;}

    public Jalon up() {return up;}
    public Jalon up(final float x, final float y) {
        this.up = new Jalon(x, y);
        return up.down = this;
    }

    public Jalon down() {return down;}
    public Jalon down(final float x, final float y) {
        this.down = new Jalon(x, y);
        return down.up = this;
    }

    public Jalon left() {return left;}
    public Jalon left(final float x, final float y) {
        this.left = new Jalon(x, y);
        return left.right = this;
    }

    public Jalon right() {return left;}
    public Jalon right(final float x, final float y) {
        this.right = new Jalon(x, y);
        return right.left = this;
    }

    public List<Jalon> listAll() {return listExcept(null);}
    protected List<Jalon> listExcept(final Jalon except) {
        final List<Jalon> jalons = new ArrayList<>();
        if (this != except) jalons.add(this);
        if (up != null && up != except) jalons.addAll(up.listExcept(this));
        if (down != null && down != except) jalons.addAll(down.listExcept(this));
        if (left != null && left != except) jalons.addAll(left.listExcept(this));
        if (right != null && right != except) jalons.addAll(right.listExcept(this));
        return jalons;
    }
}

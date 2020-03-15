package net.earomc.twwind;

import com.sun.javafx.geom.Vec2d;
import com.sun.javafx.geom.Vec2f;

public class Vector2 extends Vec2d implements Cloneable {

    public Vector2() {}

    public Vector2(int x, double y) {
        super(x, y);
    }

    public Vector2(double x, double y) {
        super(x, y);
    }

    public Vector2(Vec2d v) {
        super(v);
    }

    public Vector2(Vec2f v) {
        super(v);
    }

    public void add(Vec2d vec2d) {
        this.x = vec2d.x + this.x;
        this.y = vec2d.y + this.y;
    }

    public void add(Vec2f vec2f) {
        this.x = vec2f.x + this.x;
        this.y = vec2f.y + this.y;
    }

    public void add(double x, double y) {
        this.x+=x;
        this.y+=y;
    }

    public void subtract(Vec2d vec2d) {
        this.x = vec2d.x - this.x;
        this.y = vec2d.y - this.y;
    }

    public void subtract(Vec2f vec2f) {
        this.x = vec2f.x - this.x;
        this.y = vec2f.y - this.y;
    }

    public void subtract(double x, double y) {
        this.x-=x;
        this.y-=y;
    }

    /**
     * multiplies the vector's parameters with a single multiplier.
     * @param multiplier
     */
    public void multiply(double multiplier) {
        this.x*=multiplier;
        this.y*=multiplier;
    }

    public double dotProduct(Vec2d vec2d) {
        return this.x * vec2d.x + this.y * vec2d.y;
    }

    /**
     *
     * @param vector2 the vector that you want to get the angle to this vector from.
     * @return returns the angle between those two vectors in radians.
     */
    public double angle(Vector2 vector2) {
        double d1 = vector2.length() * this.length();
        double dotProduct = dotProduct(vector2);

        return Math.acos(dotProduct / d1);
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    @Override
    public Vector2 clone() {
        Vector2 cloned = null;
        try {
            cloned = (Vector2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloned;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " x: " + this.x + " y: " + this.y;
    }
}

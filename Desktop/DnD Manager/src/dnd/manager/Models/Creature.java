/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.manager.Models;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author cvdk9
 */
public abstract class Creature {
    private int health;
    private int maxHealth;
    private int bonusHealth;
    private int armorClass;
    private int movementSpeed;
    private List<Point> route;
    private HashMap stats = new HashMap();
    private List<String> backPack = new ArrayList<String>();
    private areaMap area;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public void setBonusHealth(int bonusHealth) {
        this.bonusHealth = bonusHealth;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public List<Point> getRoute() {
        return route;
    }

    public void setRoute(List<Point> route) {
        this.route = route;
    }

    public HashMap getStats() {
        return stats;
    }

    public void setStats(HashMap stats) {
        this.stats = stats;
    }

    public List<String> getBackPack() {
        return backPack;
    }

    public void setBackPack(List<String> backPack) {
        this.backPack = backPack;
    }

    public areaMap getArea() {
        return area;
    }

    public void setArea(areaMap area) {
        this.area = area;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
    private Point location;
}

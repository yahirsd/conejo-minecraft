/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yahirsd.conejo.utils;

import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3d;

/**
 *
 * @author yahirsd
 */
public class Transform3DBuilder {
    final private Transform3D transform3D = new Transform3D();
    
    public Transform3DBuilder movX(double x){
        Transform3D tmp = new Transform3D();
        tmp.setTranslation(new Vector3d(x, 0, 0));
        transform3D.mul(tmp);
        return this;
    }
    
    public Transform3DBuilder movY(double y){
        Transform3D tmp = new Transform3D();
        tmp.setTranslation(new Vector3d(0, y, 0));
        transform3D.mul(tmp);
        return this;
    }
    
    public Transform3DBuilder movZ(double z){
        Transform3D tmp = new Transform3D();
        tmp.setTranslation(new Vector3d(0, 0, z));
        transform3D.mul(tmp);
        return this;
    }

    public Transform3D getTransform3D() {
        return transform3D;
    }
    
}

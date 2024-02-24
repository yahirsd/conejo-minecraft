/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yahirsd.conejo.models;

import com.sun.j3d.utils.geometry.Box;
import com.yahirsd.conejo.utils.AppearanceTexture;
import com.yahirsd.conejo.utils.Transform3DBuilder;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

/**
 *
 * @author yahirsd
 */
public class Rabbit {

    /**
     * BranchGroup que contiene todo los componentes de la cabeza.
     */
    final BranchGroup head = new BranchGroup();

    /**
     * constructor para la clase Head.
     */
    public Rabbit() {
        TransformGroup headTG = new TransformGroup();
        TransformGroup earLeftTG = new TransformGroup();
        TransformGroup earRightTG = new TransformGroup();
        TransformGroup trunkTG = new TransformGroup();
        TransformGroup armLeftTG = new TransformGroup();
        TransformGroup armRightTG = new TransformGroup();
        TransformGroup footLeftTG = new TransformGroup();
        TransformGroup footRightTG = new TransformGroup();

        Box cube = new Box(0.8f, 0.8f, 0.8f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/head_3.png"));
        cube.getShape(0).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/head_1.png"));
        cube.getShape(3).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/head_2.png"));
        cube.getShape(2).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/head_4.png"));

        Box earLeft = new Box(0.2f, 0.4f, 0.3f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_side.png"));
        earLeft.getShape(0).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_front.png"));

        Transform3D t3dEarLeft = new Transform3DBuilder()
                .movY(1.2)
                .movX(-0.4)
                .getTransform3D();
        earLeftTG.setTransform(t3dEarLeft);
        earLeftTG.addChild(earLeft);

        Box earRight = new Box(0.2f, 0.4f, 0.3f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_side.png"));
        earRight.getShape(0).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_front.png"));

        Transform3D t3dEarRight = new Transform3DBuilder()
                .movY(1.2)
                .movX(0.4)
                .getTransform3D();
        earRightTG.setTransform(t3dEarRight);
        earRightTG.addChild(earRight);

        Box trunk = new Box(0.6f, 0.6f, 0.6f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/back.png"));
        trunk.getShape(0).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/front.png"));
        
        Transform3D t3dTrunk = new Transform3DBuilder().movY(-1.4).getTransform3D();
        trunkTG.setTransform(t3dTrunk);
        trunkTG.addChild(trunk);
        
        Box armLeft = new Box(0.1f, 0.6f, 0.2f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/arm_front.png"));
        armLeft.getShape(5).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_side.png"));
        Transform3D t3dArmLeft = new Transform3DBuilder()
                .movX(-0.7)
                .movY(-1.4)
                .getTransform3D();
        armLeftTG.setTransform(t3dArmLeft);
        armLeftTG.addChild(armLeft);
        
        Box armRight = new Box(0.1f, 0.6f, 0.2f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/arm_front.png"));
        armRight.getShape(5).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_side.png"));
        Transform3D t3dArmRight = new Transform3DBuilder()
                .movX(0.7)
                .movY(-1.4)
                .getTransform3D();
        armRightTG.setTransform(t3dArmRight);
        armRightTG.addChild(armRight);
        
        
        Box footLeft = new Box(0.2f, 0.2f, 0.2f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/shoes.png"));
        Transform3D t3dFootLeft = new Transform3DBuilder()
                .movX(-0.3)
                .movY(-2.2)
                .getTransform3D();
        footLeftTG.setTransform(t3dFootLeft);
        footLeftTG.addChild(footLeft);
        
        Box footRight = new Box(0.2f, 0.2f, 0.2f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/shoes.png"));
        Transform3D t3dFootRight = new Transform3DBuilder()
                .movX(0.3)
                .movY(-2.2)
                .getTransform3D();
        footRightTG.setTransform(t3dFootRight);
        footRightTG.addChild(footRight);
        
        headTG.addChild(cube);
        headTG.addChild(earLeftTG);
        headTG.addChild(earRightTG);
        headTG.addChild(trunkTG);
        headTG.addChild(armLeftTG);
        headTG.addChild(armRightTG);
        headTG.addChild(footLeftTG);
        headTG.addChild(footRightTG);

        head.addChild(headTG);
    }

    /**
     * retorna el BranchGroup de la cabeza.
     *
     * @return head
     */
    public BranchGroup getHeadBG() {
        return head;
    }

}

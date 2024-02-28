/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yahirsd.conejo.models;

import com.sun.j3d.utils.geometry.Box;
import com.yahirsd.conejo.utils.AppearanceTexture;
import com.yahirsd.conejo.utils.Transform3DBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

/**
 *
 * @author yahirsd
 */
public class Rabbit {

    private final Transform3DBuilder t3dMovEarLeft = new Transform3DBuilder();
    private final Transform3DBuilder t3dMovEarRight = new Transform3DBuilder();
    private final Transform3DBuilder t3dMovHead = new Transform3DBuilder();
    private final BranchGroup rabbitBG = new BranchGroup();
    private final TransformGroup earLeftTG = new TransformGroup();
    private final TransformGroup earRightTG = new TransformGroup();
    private final TransformGroup headTG = new TransformGroup();
    private final TransformGroup trunkTG = new TransformGroup();
    private final TransformGroup armLeftTG = new TransformGroup();
    private final TransformGroup armRightTG = new TransformGroup();
    private final TransformGroup footLeftTG = new TransformGroup();
    private final TransformGroup footRightTG = new TransformGroup();

    private boolean flagMovWalk = false;
    private boolean flagSpecialMov = false;

    /**
     * constructor para la clase Head.
     */
    public Rabbit() {

        headTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        earRightTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        earLeftTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

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

        rabbitBG.addChild(getHead());
        rabbitBG.addChild(trunkTG);
        rabbitBG.addChild(armLeftTG);
        rabbitBG.addChild(armRightTG);
        rabbitBG.addChild(footLeftTG);
        rabbitBG.addChild(footRightTG);

        initThreades();
    }

    /**
     * retorna un TransformGroup que contiene la oreje izquierda del conejo.
     *
     * @return la oreja izquierda del conejo.
     */
    private TransformGroup getEarLeftBG() {

        final TransformGroup tmpEarLeftTG = new TransformGroup();
        t3dMovEarLeft.movY(0.8).movX(-0.4);
        earLeftTG.setTransform(t3dMovEarLeft.getTransform3D());

        Box earLeft = new Box(0.2f, 0.4f, 0.3f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_side.png"));
        earLeft.getShape(0).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_front.png"));

        Transform3D t3dEarLeft = new Transform3DBuilder()
                .movY(0.4)
                .getTransform3D();

        tmpEarLeftTG.setTransform(t3dEarLeft);
        tmpEarLeftTG.addChild(earLeft);

        earLeftTG.addChild(tmpEarLeftTG);

        return earLeftTG;
    }

    /**
     * retorna un TransformGroup que contiene la oreje derecha del conejo.
     *
     * @return la oreja derecha del conejo.
     */
    private TransformGroup getEarRight() {

        final TransformGroup tmpEarRight = new TransformGroup();
        t3dMovEarRight.movY(0.8).movX(0.4);
        earRightTG.setTransform(t3dMovEarRight.getTransform3D());
        Box earRight = new Box(0.2f, 0.4f, 0.3f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_side.png"));
        earRight.getShape(0).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_front.png"));

        Transform3D t3dEarRight = new Transform3DBuilder()
                .movY(0.4)
                .getTransform3D();

        tmpEarRight.setTransform(t3dEarRight);
        tmpEarRight.addChild(earRight);
        earRightTG.addChild(tmpEarRight);
        return earRightTG;
    }

    /**
     * Retorna la cabeza del conejo.
     *
     * @return retorna el TransformGroup que contiene la cabeza.
     */
    private TransformGroup getHead() {

        final Box head = new Box(0.8f, 0.8f, 0.8f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/head_3.png"));
        head.getShape(0).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/head_1.png"));
        head.getShape(3).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/head_2.png"));
        head.getShape(2).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/head_4.png"));

        headTG.addChild(head);
        headTG.addChild(getEarRight());
        headTG.addChild(getEarLeftBG());

        return headTG;
    }

    private void initThreades() {
        Thread threadMovEarLeft = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                }

                while (flagMovWalk) {
                    for (int i = 0; i < 20; i++) {
                        t3dMovEarLeft.rotX(-1);
                        earLeftTG.setTransform(t3dMovEarLeft.getTransform3D());
                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    for (int i = 0; i < 40; i++) {
                        t3dMovEarLeft.rotX(1);
                        earLeftTG.setTransform(t3dMovEarLeft.getTransform3D());
                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    for (int i = 0; i < 20; i++) {
                        t3dMovEarLeft.rotX(-1);
                        earLeftTG.setTransform(t3dMovEarLeft.getTransform3D());
                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }

        });

        Thread threadMovEarRight = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                }

                while (flagMovWalk) {
                    for (int i = 0; i < 20; i++) {
                        t3dMovEarRight.rotX(1);
                        earRightTG.setTransform(t3dMovEarRight.getTransform3D());
                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    for (int i = 0; i < 40; i++) {
                        t3dMovEarRight.rotX(-1);
                        earRightTG.setTransform(t3dMovEarRight.getTransform3D());
                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    for (int i = 0; i < 20; i++) {
                        t3dMovEarRight.rotX(1);
                        earRightTG.setTransform(t3dMovEarRight.getTransform3D());
                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        });

        Thread threadMovHead = new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (flagMovWalk) {
                    for (int i = 0; i < 10; i++) {
                        t3dMovHead.movY(0.01);
                        headTG.setTransform(t3dMovHead.getTransform3D());
                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    for (int i = 0; i < 10; i++) {
                        t3dMovHead.movY(-0.01);
                        headTG.setTransform(t3dMovHead.getTransform3D());
                        try {
                            Thread.sleep(15);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        });

        threadMovHead.start();
        threadMovEarLeft.start();
        threadMovEarRight.start();
    }

    public void startWalk() {
        flagMovWalk = true;
    }

    public void stopWalk() {
        flagMovWalk = false;
    }

    public BranchGroup getRabbitBG() {

        return rabbitBG;
    }

}

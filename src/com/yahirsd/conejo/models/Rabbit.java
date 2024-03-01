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
    private final Transform3DBuilder t3dMovTrunk = new Transform3DBuilder();
    private final Transform3DBuilder t3ddMovArmLeft = new Transform3DBuilder();
    private final Transform3DBuilder t3dMovArmRight = new Transform3DBuilder();
    private final Transform3DBuilder t3dMovFootLeft = new Transform3DBuilder();
    private final Transform3DBuilder t3dMovFootRight = new Transform3DBuilder();
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
        trunkTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        armLeftTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        armRightTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        footLeftTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        footRightTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        rabbitBG.addChild(getHead());
        rabbitBG.addChild(getTrunk());
        rabbitBG.addChild(getArmLeft());
        rabbitBG.addChild(getArmRight());
        rabbitBG.addChild(getFootLeft());
        rabbitBG.addChild(getFootRight());

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

    private TransformGroup getTrunk() {

        Box trunk = new Box(0.6f, 0.6f, 0.6f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/back.png"));
        trunk.getShape(0).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/front.png"));

        Transform3D t3dTrunk = new Transform3DBuilder().movY(-1.4).getTransform3D();
        trunkTG.setTransform(t3dTrunk);
        trunkTG.addChild(trunk);

        return trunkTG;
    }

    private TransformGroup getArmLeft() {

        final TransformGroup tmpArmLeftTG = new TransformGroup();

        t3ddMovArmLeft.movX(-0.7).movY(-0.8);
        armLeftTG.setTransform(t3ddMovArmLeft.getTransform3D());

        Box armLeft = new Box(0.1f, 0.6f, 0.2f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/arm_front.png"));
        armLeft.getShape(5).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_side.png"));

        Transform3D t3dArmLeft = new Transform3DBuilder()
                .movY(-0.6)
                .getTransform3D();

        tmpArmLeftTG.setTransform(t3dArmLeft);
        tmpArmLeftTG.addChild(armLeft);
        armLeftTG.addChild(tmpArmLeftTG);

        return armLeftTG;
    }

    private TransformGroup getArmRight() {

        final TransformGroup tmpArmRightTG = new TransformGroup();

        t3dMovArmRight.movX(0.7).movY(-0.8);
        armRightTG.setTransform(t3dMovArmRight.getTransform3D());

        Box armRight = new Box(0.1f, 0.6f, 0.2f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/arm_front.png"));
        armRight.getShape(5).setAppearance(AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/ear_side.png"));

        Transform3D t3dArmRight = new Transform3DBuilder()
                .movY(-0.6)
                .getTransform3D();

        tmpArmRightTG.setTransform(t3dArmRight);
        tmpArmRightTG.addChild(armRight);
        armRightTG.addChild(tmpArmRightTG);

        return armRightTG;
    }

    private TransformGroup getFootLeft() {

        final TransformGroup tmpFootLeftTG = new TransformGroup();

        t3dMovFootLeft.movY(-2).movX(-0.3);
        footLeftTG.setTransform(t3dMovFootLeft.getTransform3D());

        Box footLeft = new Box(0.2f, 0.2f, 0.2f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/shoes.png"));
        Transform3D t3dFootLeft = new Transform3DBuilder()
                .movY(-0.2)
                .getTransform3D();
        tmpFootLeftTG.setTransform(t3dFootLeft);
        tmpFootLeftTG.addChild(footLeft);
        footLeftTG.addChild(tmpFootLeftTG);

        return footLeftTG;
    }

    private TransformGroup getFootRight() {

        final TransformGroup tmpFootRightTG = new TransformGroup();

        t3dMovFootRight.movY(-2).movX(0.3);
        footRightTG.setTransform(t3dMovFootRight.getTransform3D());

        Box footRight = new Box(0.2f, 0.2f, 0.2f, AppearanceTexture.FLAGS, AppearanceTexture.getAppearance("src/com/yahirsd/conejo/img/shoes.png"));
        Transform3D t3dFootRight = new Transform3DBuilder()
                .movY(-0.2)
                .getTransform3D();
        tmpFootRightTG.setTransform(t3dFootRight);
        tmpFootRightTG.addChild(footRight);
        footRightTG.addChild(tmpFootRightTG);

        return footRightTG;
    }

    private void initThreades() {
        Thread threadMovEarLeft = new Thread(() -> {
            while (true) {
                sleep();

                while (flagMovWalk) {
                    for (int i = 0; i < 20; i++) {
                        t3dMovEarLeft.rotX(-1);
                        earLeftTG.setTransform(t3dMovEarLeft.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 20; i++) {
                        t3dMovEarLeft.rotX(1);
                        earLeftTG.setTransform(t3dMovEarLeft.getTransform3D());
                        sleep();
                    }

                    if (!flagMovWalk) {
                        continue;
                    }

                    for (int i = 0; i < 20; i++) {
                        t3dMovEarLeft.rotX(1);
                        earLeftTG.setTransform(t3dMovEarLeft.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 20; i++) {
                        t3dMovEarLeft.rotX(-1);
                        earLeftTG.setTransform(t3dMovEarLeft.getTransform3D());
                        sleep();
                    }

                }
            }

        });

        Thread threadMovEarRight = new Thread(() -> {
            while (true) {
                sleep();

                while (flagMovWalk) {
                    for (int i = 0; i < 20; i++) {
                        t3dMovEarRight.rotX(1);
                        earRightTG.setTransform(t3dMovEarRight.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 20; i++) {
                        t3dMovEarRight.rotX(-1);
                        earRightTG.setTransform(t3dMovEarRight.getTransform3D());
                        sleep();
                    }

                    if (!flagMovWalk) {
                        continue;
                    }

                    for (int i = 0; i < 20; i++) {
                        t3dMovEarRight.rotX(-1);
                        earRightTG.setTransform(t3dMovEarRight.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 20; i++) {
                        t3dMovEarRight.rotX(1);
                        earRightTG.setTransform(t3dMovEarRight.getTransform3D());
                        sleep();
                    }

                }
            }

        });

        Thread threadMovHead = new Thread(() -> {

            while (true) {
                sleep();
                while (flagMovWalk) {
                    for (int i = 0; i < 15; i++) {
                        t3dMovHead.movY(0.005);
                        headTG.setTransform(t3dMovHead.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 15; i++) {
                        t3dMovHead.movY(-0.005);
                        headTG.setTransform(t3dMovHead.getTransform3D());
                        sleep();
                    }
                }
            }

        });

        Thread threadMovArmLeft = new Thread(() -> {
            while (true) {
                sleep();

                while (flagMovWalk) {
                    for (int i = 0; i < 15; i++) {
                        t3ddMovArmLeft.rotX(-3);
                        armLeftTG.setTransform(t3ddMovArmLeft.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 15; i++) {
                        t3ddMovArmLeft.rotX(3);
                        armLeftTG.setTransform(t3ddMovArmLeft.getTransform3D());
                        sleep();
                    }

                    if (!flagMovWalk) {
                        continue;
                    }
                    for (int i = 0; i < 15; i++) {
                        t3ddMovArmLeft.rotX(3);
                        armLeftTG.setTransform(t3ddMovArmLeft.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 15; i++) {
                        t3ddMovArmLeft.rotX(-3);
                        armLeftTG.setTransform(t3ddMovArmLeft.getTransform3D());
                        sleep();
                    }

                }
            }
        });

        Thread threadMovArmRight = new Thread(() -> {
            while (true) {
                sleep();

                while (flagMovWalk) {

                    for (int i = 0; i < 15; i++) {
                        t3dMovArmRight.rotX(3);
                        armRightTG.setTransform(t3dMovArmRight.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 15; i++) {
                        t3dMovArmRight.rotX(-3);
                        armRightTG.setTransform(t3dMovArmRight.getTransform3D());
                        sleep();
                    }

                    if (!flagMovWalk) {
                        continue;
                    }

                    for (int i = 0; i < 15; i++) {
                        t3dMovArmRight.rotX(-3);
                        armRightTG.setTransform(t3dMovArmRight.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 15; i++) {
                        t3dMovArmRight.rotX(3);
                        armRightTG.setTransform(t3dMovArmRight.getTransform3D());
                        sleep();
                    }

                }
            }
        });

        Thread threadMovFootLeft = new Thread(() -> {

            while (true) {
                sleep();
                while (flagMovWalk) {
                    for (int i = 0; i < 15; i++) {
                        t3dMovFootLeft.rotX(3);
                        footLeftTG.setTransform(t3dMovFootLeft.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 15; i++) {
                        t3dMovFootLeft.rotX(-3);
                        footLeftTG.setTransform(t3dMovFootLeft.getTransform3D());
                        sleep();
                    }

                    if (!flagMovWalk) {
                        continue;
                    }

                    for (int i = 0; i < 15; i++) {
                        t3dMovFootLeft.rotX(-3);
                        footLeftTG.setTransform(t3dMovFootLeft.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 15; i++) {
                        t3dMovFootLeft.rotX(3);
                        footLeftTG.setTransform(t3dMovFootLeft.getTransform3D());
                        sleep();
                    }
                }
            }
        });

        Thread threadMovFootRight = new Thread(() -> {

            while (true) {
                sleep();
                while (flagMovWalk) {
                    for (int i = 0; i < 15; i++) {
                        t3dMovFootRight.rotX(-3);
                        footRightTG.setTransform(t3dMovFootRight.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 15; i++) {
                        t3dMovFootRight.rotX(3);
                        footRightTG.setTransform(t3dMovFootRight.getTransform3D());
                       sleep();
                    }

                    if (!flagMovWalk) {
                        continue;
                    }

                    for (int i = 0; i < 15; i++) {
                        t3dMovFootRight.rotX(3);
                        footRightTG.setTransform(t3dMovFootRight.getTransform3D());
                        sleep();
                    }

                    for (int i = 0; i < 15; i++) {
                        t3dMovFootRight.rotX(-3);
                        footRightTG.setTransform(t3dMovFootRight.getTransform3D());
                        sleep();
                    }
                }
            }
        });
        threadMovFootRight.start();
        threadMovFootLeft.start();
        threadMovArmLeft.start();
        threadMovArmRight.start();
        threadMovHead.start();
        threadMovEarLeft.start();
        threadMovEarRight.start();
    }

    private void sleep() {
        try {
            Thread.sleep(15);
        } catch (InterruptedException ex) {
            Logger.getLogger(Rabbit.class.getName()).log(Level.SEVERE, null, ex);
        }
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

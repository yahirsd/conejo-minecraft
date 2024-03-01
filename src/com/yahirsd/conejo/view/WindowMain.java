/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yahirsd.conejo.view;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.yahirsd.conejo.models.Rabbit;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JPanel;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author yahirsd
 */
public final class WindowMain extends JPanel {

    Rabbit rabbit = new Rabbit();

    public WindowMain() {

        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas = new Canvas3D(config);
        canvas.addKeyListener(new Move());
        setLayout(new BorderLayout());
        add(canvas);

        SimpleUniverse universe = new SimpleUniverse(canvas);

        Vector3f pointOfViewVector3f = new Vector3f(0f, 0f, 15f);
        Transform3D pointOfViewTransform = new Transform3D();
        pointOfViewTransform.setTranslation(pointOfViewVector3f);
        universe.getViewingPlatform().getViewPlatformTransform().setTransform(pointOfViewTransform);

        final BranchGroup scene = createUniverse();
        scene.compile();
        universe.addBranchGraph(scene);
    }

    public BranchGroup createUniverse() {
        final BranchGroup root = new BranchGroup();

        TransformGroup mouseGroup = new TransformGroup();
        mouseGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        mouseGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        mouseGroup.addChild(rabbit.getRabbitBG());

        MouseRotate mr = new MouseRotate();
        mr.setTransformGroup(mouseGroup);
        mr.setSchedulingBounds(new BoundingSphere(new Point3d(), 100f));

        root.addChild(mr);
        root.addChild(mouseGroup);
        return root;
    }

    public class Move extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_W:
                    rabbit.startWalk();
                    //System.out.println("Tecla presionada en el panel: " + KeyEvent.getKeyText(keyCode));
                    break;
                default:
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_W:
                    rabbit.stopWalk();
                    System.out.println("Tecla presionada en el panel: " + KeyEvent.getKeyText(keyCode));
                    break;
                default:
            }
        }
    }
}

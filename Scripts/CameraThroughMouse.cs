using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraFollowToRover : MonoBehaviour
{
    private Camera CameraToRover;

    void Start()
    {
        CameraToRover = Camera.main;
    }

    void OnGUI()
    {
        Vector2 MouseTargetPosition = new Vector2();
        Vector3 position = new Vector3();
        Event   Event = Event.current;

        MouseTargetPosition.x = currentEvent.mousePosition.x;
        MouseTargetPosition.y = cam.pixelHeight - currentEvent.mousePosition.y;

        point = CameraToRover.ScreenToWorldPoint(new Vector3(MouseTargetPosition.x, MouseTargetPosition.y, CameraToRover.nearClipPlane));

        GUILayout.BeginArea(new Rect(20, 20, 250, 120));
        GUILayout.Label("Pixel: " + CameraToRover.pixelWidth + ":" + CameraToRover.pixelHeight);
        GUILayout.Label("MouseTargetPosition: " + MouseTargetPosition);
        GUILayout.Label("PositionRover: " + position.ToString("F3"));
        GUILayout.EndArea();
    }
}
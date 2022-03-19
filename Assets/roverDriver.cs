using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class roverDriver : MonoBehaviour
{

    private float speed;
    private float maximum_speed = 70f;
    private float minimum_speed = -40f;
    private float acc = 30f;
    private float speed_of_brake = 100f;
    private float speed_of_reverse = 30f;
    private float slowDown = 10f;

    private float turnSpeed;
    private float maxTurn = 300f;
    private float accTurn = 300f;
    private float slowTurn = 500f;

    private float forwardAmount;
    private float turnAmount;

    private Rigidbody roverBody;
  
    private void Awake()
    {
        roverBody = GetComponent<Rigidbody>();
    }

    private void Update()
    {
        if (forwardAmount > 0) 
        {
            speed += forwardAmount * acc * Time.deltaTime;
        }
        if (forwardAmount < 0)
        {
            if (speed > 0)
            {
                speed += forwardAmount * speed_of_brake * Time.deltaTime;
            }
            else
            {
                speed += forwardAmount * speed_of_reverse * Time.deltaTime;
            }
        }

        if (forwardAmount == 0)
        {
            if (speed > 0)
            {
                speed -= slowDown * Time.deltaTime;
            }
            if (speed < 0)
            {
                speed += slowDown * Time.deltaTime;
            }
        }

        speed = Mathf.Clamp(speed, minimum_speed, maximum_speed);

        roverBody.velocity = transform.forward * speed;

        if (speed < 0)
        {
            turnAmount = turnAmount * -1f;
        }

        if (turnAmount > 0 || turnAmount < 0)
        {
            if ((turnSpeed > 0 && turnAmount < 0) || (turnSpeed < 0 && turnAmount > 0))
            {
                float minTurnAmount = 20f;
                turnSpeed = turnAmount * minTurnAmount;
            }
            turnSpeed += turnAmount * accTurn * Time.deltaTime;
        }
        else
        {
            // Not turning
            if (turnSpeed > 0)
            {
                turnSpeed -= slowTurn * Time.deltaTime;
            }
            if (turnSpeed < 0)
            {
                turnSpeed += slowTurn * Time.deltaTime;
            }
            if (turnSpeed > -1f && turnSpeed < +1f)
            {
                // Stop rotating
                turnSpeed = 0f;
            }
        }

        float speedNormalized = speed / maximum_speed;
        float invertSpeedNormalized = Mathf.Clamp(1 - speedNormalized, .75f, 1f);

        turnSpeed = Mathf.Clamp(turnSpeed, -maxTurn, maxTurn);

        roverBody.angularVelocity = new Vector3(0, turnSpeed * (invertSpeedNormalized * 1f) * Mathf.Deg2Rad, 0);

        if (transform.eulerAngles.x > 2 || transform.eulerAngles.x < -2 || transform.eulerAngles.z > 2 || transform.eulerAngles.z < -2)
        {
            transform.eulerAngles = new Vector3(0, transform.eulerAngles.y, 0);
        }
    }
}

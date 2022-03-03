using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Cube_Jump : MonoBehaviour
{
    public float speed=10f;
    public float jumpSpeed=10f;
    public float distanceToGround=0.5f;
    Rigidbody rb;

    // Start is called before the first frame update

    void Start()
    {
        rb=GetComponent<Rigidbody>();
    }

    // Update is called once per frame

    void FixedUpdate()
    { 
        // The following is the key for jumping using the space key

        if(Input.GetKey(KeyCode.Space) ){
           rb.AddForce(0,11f,0);
        }

        float horizontal=Input.GetAxis("Horizontal");
        float vertical=Input.GetAxis("Vertical");

        Vector3 movement= new Vector3(horizontal*speed*Time.deltaTime,0,vertical*speed*Time.deltaTime);                     // deltaTime for converting time from per frame to per seconds while movement

        rb.MovePosition(transform.position+movement);
    }
}

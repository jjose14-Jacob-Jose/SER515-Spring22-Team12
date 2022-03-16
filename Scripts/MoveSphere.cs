using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveSphere : MonoBehaviour
{
    public float speed = 0.1f;
   // private Rigidbody rigid;

   // void Start() {
   //     rigid = GetComponent<Rigidbody>();
   // }

    void FixedUpdate()
    {
        float xDirection = Input.GetAxisRaw("Horizontal");
        float zDirection = Input.GetAxisRaw("Vertical");

        Vector3 moveDirection = new Vector3(xDirection,0.0f, zDirection);

         transform.position += moveDirection * speed; 
        //rigid.AddForce(moveDirection * speed);

    }
}

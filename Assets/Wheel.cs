using UnityEngine;

public class Wheel : MonoBehaviour
{
    #region --- helper ---
    [System.Serializable]
    public struct WheelInfo
    {
        public Transform visualwheel;
        public WheelCollider wheelcollider;
    }
    #endregion 

    public float motor = 800;
    public float steer = 50;
    public float brake = 440;
    public WheelInfo leftWheel;
    public WheelInfo rightWheel;
    public WheelInfo BL;
    public WheelInfo BR;
    public float frontSensorPosition = 0.5f;
    public float sensorLength = 3f;
    public float sideSensorPosition = 0.2f;
    public float frontSensorAngle = 30;
  
    private void Start()
    {
        GetTheWheels();
    }
    private void FixedUpdate()
    {
        Sensors();
        if(GetComponent<Rigidbody>().centerOfMass.y > 0)
        GetComponent<Rigidbody>().centerOfMass = Vector3.zero;
        float vert = Input.GetAxis("Vertical"); 
        float horz = Input.GetAxis("Horizontal");
        leftWheel.wheelcollider.steerAngle = horz * steer;
        rightWheel.wheelcollider.steerAngle = horz * steer;
        leftWheel.wheelcollider.motorTorque = (vert * motor)/3;
        rightWheel.wheelcollider.motorTorque = (vert * motor)/3;

        if (Input.GetButton("Fire1") == true) 
        {
            leftWheel.wheelcollider.brakeTorque = brake;
            rightWheel.wheelcollider.brakeTorque = brake;
        }
        else
        {
            leftWheel.wheelcollider.brakeTorque = 0;
            rightWheel.wheelcollider.brakeTorque = 0;
        }

        UpdateVisualWheels();
    }

    private void Sensors()
    {
        RaycastHit hit;
        Vector3 sensorPosStart = transform.position;
        sensorPosStart.z += frontSensorPosition;

        //front center sensor
        if(Physics.Raycast(sensorPosStart,transform.forward,out hit, sensorLength))
        {
            Debug.DrawLine(sensorPosStart, hit.point,Color.blue);
        }

        //front right sensor
        sensorPosStart.x  += frontSensorPosition;
        if (Physics.Raycast(sensorPosStart, transform.forward, out hit, sensorLength))
        {
            Debug.DrawLine(sensorPosStart, hit.point,Color.blue);

        }

        //front right angle sensor
        if (Physics.Raycast(sensorPosStart, Quaternion.AngleAxis(frontSensorAngle, transform.up) * transform.forward, out hit, sensorLength))
        {
            Debug.DrawLine(sensorPosStart, hit.point, Color.blue);
        }

        //front left sensor
        sensorPosStart.x -= 2 * frontSensorPosition;

        if (Physics.Raycast(sensorPosStart, transform.forward, out hit, sensorLength))
        {
            Debug.DrawLine(sensorPosStart, hit.point,Color.blue);
        }

        //front left angle sensor
        if (Physics.Raycast(sensorPosStart, Quaternion.AngleAxis(frontSensorAngle, transform.up) * transform.forward, out hit, sensorLength))
        {
            Debug.DrawLine(sensorPosStart, hit.point,Color.blue);
        }

    }

    private void UpdateVisualWheels()
    {
        Vector3 pos;
        Quaternion rot;

        leftWheel.wheelcollider.GetWorldPose(out pos, out rot);
        leftWheel.visualwheel.position = pos;
        leftWheel.visualwheel.rotation = rot;

        rightWheel.wheelcollider.GetWorldPose(out pos, out rot);
        rightWheel.visualwheel.position = pos;
        rightWheel.visualwheel.rotation = rot;
}
    private void GetTheWheels()
    {
        GameObject wheels = GetChildByName(this.gameObject, "Wheels");        
        leftWheel.visualwheel = GetChildByName(wheels, "leftWheel").transform;
        rightWheel.visualwheel = GetChildByName(wheels, "rightWheel").transform;

        GameObject colliders = GetChildByName(this.gameObject, "Colliders");
        leftWheel.wheelcollider = GetChildByName(colliders, "wcleftWheel").GetComponent<WheelCollider>();        
        rightWheel.wheelcollider = GetChildByName(colliders, "wcrightWheel").GetComponent<WheelCollider>();
    }
    private GameObject GetChildByName(GameObject go, string name)
    {
        for (int i = 0; i < go.transform.childCount; i++)
        {
            if (go.transform.GetChild(i).name == name)  
            {
                return go.transform.GetChild(i).gameObject;
            }
        }
        Debug.LogError("Error: Could not find the child " + name + ". Check spelling and case.");
        return null;
    }
}

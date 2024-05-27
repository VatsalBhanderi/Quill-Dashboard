import React from 'react';
import { LineChart, Line, BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';

const ChartComponent = ({ chart }) => {
  const { chartType, data, xName, yName, chartName } = chart;

  const CustomTooltip = ({ active, payload, label }) => {
    if (active && payload && payload.length) {
      return (
        <div className="p-4 bg-slate-900 flex flex-col gap-4 rounded-md">
          <p className="text-sm text-blue-400">
            {xName}:
            <span className="ml-2">{payload[0].payload[xName]}</span>
          </p>
          <p className="text-sm text-indigo-400">
            {yName}:
            <span className="ml-2">{payload[0].payload[yName]}</span>
          </p>
        </div>
      );
    }
  };
  // console.log("Inside ChartCOmponent", chartType, data, xName, yName, chartName);
  return (
    <div style={{ margin: '20px 0' }}>
      <h3>{chartName}</h3>
      {chartType === 'line' ? (
        <LineChart width={600} height={300} data={data} margin={{right: 30}}>
          <XAxis dataKey={xName} />
          <YAxis />
          <CartesianGrid strokeDasharray="3 3" />
          <Tooltip content={CustomTooltip}/>
          <Legend />
          <Line type="monotone" dataKey={yName} stroke="#8884d8" />
        </LineChart>
      ) : (
        
          <BarChart width={600} height={300} data={data} margin={{right: 30}}>
          <XAxis dataKey={xName} />
          <YAxis />
          <CartesianGrid strokeDasharray="3 3" />
          <Tooltip content={CustomTooltip} />
          <Legend />
          <Bar dataKey={yName} fill="#8884d8" />
        </BarChart>
       
      )}
    </div>
  );
};

export default ChartComponent;


